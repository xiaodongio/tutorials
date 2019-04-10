package com.dek;

import com.dek.service.IGetIdService;
import org.junit.Test;

import java.util.Iterator;
import java.util.ServiceLoader;

public class GetIdTest {

    @Test
    public void spiTest() {
        ServiceLoader<IGetIdService> loaders = ServiceLoader.load(IGetIdService.class);
        Iterator<IGetIdService> it = loaders.iterator();

        while (it.hasNext()) {
            System.out.println(it.next().getId());
        }
    }
}
