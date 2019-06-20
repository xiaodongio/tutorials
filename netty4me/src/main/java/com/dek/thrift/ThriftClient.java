package com.dek.thrift;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class ThriftClient {

    public static void main(String[] args) throws TException {
        TTransport transport = new TFramedTransport(new TSocket("localhost", 8080));
        TProtocol protocol = new TCompactProtocol(transport);

        TeacherService.Client client = new TeacherService.Client(protocol);
        try {
            transport.open();
            Teacher hh = client.getByName("hh");
            System.out.println(hh.getId());
            System.out.println(hh.getName());
            System.out.println(hh.getProfession());

            Teacher teacher = new Teacher();
            teacher.setId(2L);
            teacher.setName("dek2");
            teacher.setProfession("code2");
            client.save(teacher);
        } finally {
            transport.close();
        }

    }

}
