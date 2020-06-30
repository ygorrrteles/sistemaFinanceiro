package br.com.ygorteles.aprenda.rest.testeXML;

public class ContribuinteGRE {
    private String cnpj;
    private Boolean credenciadoDTE;
    private String inscricao;
    private String nomeEmpresarial;
    private String qualificacao;
    private String situacaoCadastral;
    private String tipoContribuinte;

    public ContribuinteGRE(String cnpj, Boolean credenciadoDTE, String inscricao, String nomeEmpresarial, String qualificacao, String situacaoCadastral, String tipoContribuinte) {
        this.cnpj = cnpj;
        this.credenciadoDTE = credenciadoDTE;
        this.inscricao = inscricao;
        this.nomeEmpresarial = nomeEmpresarial;
        this.qualificacao = qualificacao;
        this.situacaoCadastral = situacaoCadastral;
        this.tipoContribuinte = tipoContribuinte;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Boolean getCredenciadoDTE() {
        return credenciadoDTE;
    }

    public void setCredenciadoDTE(Boolean credenciadoDTE) {
        this.credenciadoDTE = credenciadoDTE;
    }

    public String getInscricao() {
        return inscricao;
    }

    public void setInscricao(String inscricao) {
        this.inscricao = inscricao;
    }

    public String getNomeEmpresarial() {
        return nomeEmpresarial;
    }

    public void setNomeEmpresarial(String nomeEmpresarial) {
        this.nomeEmpresarial = nomeEmpresarial;
    }

    public String getQualificacao() {
        return qualificacao;
    }

    public void setQualificacao(String qualificacao) {
        this.qualificacao = qualificacao;
    }

    public String getSituacaoCadastral() {
        return situacaoCadastral;
    }

    public void setSituacaoCadastral(String situacaoCadastral) {
        this.situacaoCadastral = situacaoCadastral;
    }

    public String getTipoContribuinte() {
        return tipoContribuinte;
    }

    public void setTipoContribuinte(String tipoContribuinte) {
        this.tipoContribuinte = tipoContribuinte;
    }

    @Override
    public String toString() {
        return "ContribuinteGRE{" +
                "cnpj='" + cnpj + '\'' +
                ", credenciadoDTE=" + credenciadoDTE +
                ", inscricao='" + inscricao + '\'' +
                ", nomeEmpresarial='" + nomeEmpresarial + '\'' +
                ", qualificacao='" + qualificacao + '\'' +
                ", situacaoCadastral='" + situacaoCadastral + '\'' +
                ", tipoContribuinte='" + tipoContribuinte + '\'' +
                '}';
    }
}
