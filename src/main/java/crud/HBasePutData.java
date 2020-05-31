package crud;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
import java.io.IOException;

public class HBasePutData {
    public static void main(String[] args) throws IOException {
        Configuration conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum","hadoopb");
        Connection conn = ConnectionFactory.createConnection(conf);
        //Table负责与记录相关的操作，如增删改查等
        TableName tableName = TableName.valueOf("t2");
        Table table = conn.getTable(tableName);
        Put put = new Put(Bytes.toBytes("row1"));//设置rowkey
        put.addColumn(Bytes.toBytes("f2"),Bytes.toBytes("name"),Bytes.toBytes("xiaoming"));
        put.addColumn(Bytes.toBytes("f2"),Bytes.toBytes("age"),Bytes.toBytes("20"));
        put.addColumn(Bytes.toBytes("f2"),Bytes.toBytes("address"),Bytes.toBytes("beijing"));

        table.put(put);
        table.close();
        System.out.println("put date successs !!");
    }
}
