package com.dxz.thrift.demo;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TServerSocket;

public class HelloServerDemo {
	public static final int SERVER_PORT = 8090;

	public void startServer() {
		try {
			System.out.println("HelloWorld TSimpleServer start ....");

			TProcessor tprocessor = new HelloWorldService.Processor<HelloWorldService.Iface>(new HelloWorldImpl());
			// HelloWorldService.Processor&lt;HelloWorldService.Iface&gt;
			// tprocessor =
			// new HelloWorldService.Processor&lt;HelloWorldService.Iface&gt;(
			// new HelloWorldImpl());

			// 简单的单线程服务模型，一般用于测试
			TServerSocket serverTransport = new TServerSocket(SERVER_PORT);
			TServer.Args tArgs = new TServer.Args(serverTransport);
			tArgs.processor(tprocessor);
			tArgs.protocolFactory(new TBinaryProtocol.Factory());
			// tArgs.protocolFactory(new TCompactProtocol.Factory());
			// tArgs.protocolFactory(new TJSONProtocol.Factory());
			TServer server = new TSimpleServer(tArgs);
			server.serve();

		} catch (Exception e) {
			System.out.println("Server start error!!!");
			e.printStackTrace();
		}
	}

	public void startServer2() {
	try {
		System.out.println("HelloWorld TNonblockingServer start ....");

		TProcessor tprocessor = new HelloWorldService.Processor<HelloWorldService.Iface>(
				new HelloWorldImpl());

		TNonblockingServerSocket tnbSocketTransport = new TNonblockingServerSocket(
				SERVER_PORT);
		TNonblockingServer.Args tnbArgs = new TNonblockingServer.Args(
				tnbSocketTransport);
		tnbArgs.processor(tprocessor);
		tnbArgs.transportFactory(new TFramedTransport.Factory());
		tnbArgs.protocolFactory(new TCompactProtocol.Factory());

		// 使用非阻塞式IO，服务端和客户端需要指定TFramedTransport数据传输的方式
		TServer server = new TNonblockingServer(tnbArgs);
		server.serve();

	} catch (Exception e) {
		System.out.println("Server start error!!!");
		e.printStackTrace();
	}
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HelloServerDemo server = new HelloServerDemo();
		server.startServer();
	}

}