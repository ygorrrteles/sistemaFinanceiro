package br.com.ygorteles.aprenda.rest.testeXML;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.InputStream;

public class LeitorXml {
    public ContribuinteGREs carregar(InputStream inputStream){
        XStream stream = new XStream(new DomDriver());
        stream.alias("contribuinteGREs", ContribuinteGREs.class);

        ContribuinteGREs contribuinteGREs =  (ContribuinteGREs) stream.fromXML(inputStream);
        return contribuinteGREs;
    }
}
