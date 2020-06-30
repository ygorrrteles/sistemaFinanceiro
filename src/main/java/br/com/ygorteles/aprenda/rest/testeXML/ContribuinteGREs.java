package br.com.ygorteles.aprenda.rest.testeXML;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.ArrayList;
import java.util.List;

@JacksonXmlRootElement
public class ContribuinteGREs {

    public ContribuinteGREs(List<ContribuinteGRE> contribuinteGREs) {
        this.contribuinteGREs = contribuinteGREs;
    }

    @XStreamAlias("contribuinteGRE")
    List<ContribuinteGRE> contribuinteGREs = new ArrayList<>();

    public List<ContribuinteGRE> getContribuinteGREList() {
        return contribuinteGREs;
    }

    public void setContribuinteGREList(List<ContribuinteGRE> contribuinteGREList) {
        this.contribuinteGREs = contribuinteGREList;
    }

    @Override
    public String toString() {
        return "ContribuinteGREs{" +
                "contribuinteGREs=" + contribuinteGREs +
                '}';
    }
}
