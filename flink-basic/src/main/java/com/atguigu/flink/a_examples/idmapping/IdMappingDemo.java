package com.atguigu.flink.a_examples.idmapping;

import org.apache.commons.lang3.StringUtils;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.RichMapFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.operators.MapOperator;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.graph.Edge;
import org.apache.flink.graph.Graph;
import org.apache.flink.graph.Vertex;
import org.apache.flink.graph.library.ConnectedComponents;
import org.apache.flink.util.Collector;

import java.util.*;

/**
 * 使用flink图计算补全hive app_log表中日志id
 */

public class IdMappingDemo {
    public static void main(String[] args) throws Exception {
        //获取flink执行环境
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        //读取hdfs数据源
        DataSource<String> applog = env.readTextFile("hdfs://hadoop102:8020/opt/module/hive/dt=2023-10-24/000000_0");
        //构造点集合
        DataSet<Vertex<String, String>> vartices = applog.flatMap(new FlatMapFunction<String, Vertex<String, String>>() {
            @Override
            public void flatMap(String s, Collector<Vertex<String, String>> collector) throws Exception {
                String[] lines = s.split("\t");
                Vertex<String, String> vertex = new Vertex<String, String>();
                for (int i = 0; i < lines.length; i++) {
                    if (StringUtils.isNotBlank(lines[i])) {
                        vertex.f0 = Integer.toString(lines[i].hashCode());
                        vertex.f1 = lines[i];
                    }
                    if(StringUtils.isNotBlank(vertex.f0)){
                        collector.collect(vertex);
                    }
                }

            }
        });
        //vartices.print();
        //构造边集合
        DataSet<Edge<String,String>> edges = applog.flatMap(new FlatMapFunction<String, Edge<String,String>>() {
            @Override
            public void flatMap(String s, Collector<Edge<String,String>> collector) throws Exception {
                String[] lines = s.split("\t");
                Edge<String,String> edge = new Edge<String,String>();
                for (int i = 0; i < lines.length - 1; i++) {
                    if (StringUtils.isNotBlank(lines[i])) {
                        edge.f0 = Integer.toString(lines[i].hashCode());
                        edge.f1 = Integer.toString(lines[i + 1].hashCode());
                        edge.f2=" ";
                    }
                    if(StringUtils.isNotBlank(edge.f0)){
                        collector.collect(edge);
                    }

                }
            }
        });
        //edges.print();

        //使用点集合和边集合构造图
        Graph<String, String, String> graph = Graph.fromDataSet(vartices, edges, env);
        //调用图的算法:连接子图算法
        DataSet<Vertex<String,String>> vertexDataSet = graph.run(new ConnectedComponents<>(10));
        //vertexDataSet.print();
        //从结果图中,取出图的点集合
        //DataSet<Vertex<String, String>> vertices2 = graph.getVertices();

        /*MapOperator<Vertex<String, String>, HashMap<String, String>> mapdata = vertexDataSet.map(new MapFunction<Vertex<String, String>, HashMap<String, String>>() {
            HashMap<String, String> map = new HashMap<>();
            @Override
            public HashMap<String, String> map(Vertex<String, String> stringStringVertex) throws Exception {
                map.put(stringStringVertex.f0, stringStringVertex.f1);
                return map;
            }
        });
        mapdata.withBroadcastSet(mapdata,"ds");*/
        /*
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + ":"+value);
        }*/

        //利用映射关系数据数据加工原始数据
        MapOperator<String, String> res = applog.map(new RichMapFunction<String, String>() {
            private HashMap<String,String> map = new HashMap<>();

            @Override
            public void open(Configuration parameters) throws Exception {
                List<Vertex<String, String>> list  =  getRuntimeContext().getBroadcastVariable("bc");
                for (Vertex<String, String> vertex : list) {
                    if(StringUtils.isNotBlank(vertex.f0)&&StringUtils.isNotBlank(vertex.f1)){
                    map.put(vertex.f0, vertex.f1);
                }
                }
            }

            @Override
            public String map(String s) throws Exception {
                String[] lines = s.split("\t");
                String result = "";
                for (String word : lines) {
                    if (StringUtils.isNotBlank(word)) {
                        result = map.get(Integer.toString(word.hashCode())) + "\t" + s;
                        break;
                    }
                }
                return result;

            }
        }).withBroadcastSet(vertexDataSet,"bc");
        res.print();


        //env.execute();
    }
}
