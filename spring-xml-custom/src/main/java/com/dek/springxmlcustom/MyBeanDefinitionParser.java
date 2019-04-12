package com.dek.springxmlcustom;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

public class MyBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

    @Override
    protected Class<?> getBeanClass(Element element) {
        return MyBean.class;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        String id = element.getAttribute("id");
        builder.addPropertyValue("id", Integer.parseInt(id));

         // this however is an optional property
        String name = element.getAttribute("name");
        if (StringUtils.hasText(name)) {
            builder.addPropertyValue("name", name);
        }
    }
}
