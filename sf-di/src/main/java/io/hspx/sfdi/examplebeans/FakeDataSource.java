package io.hspx.sfdi.examplebeans;

public class FakeDataSource {
    private String user;
    private String password;
    private String url;
    private String javaHomePath;
    private String customPropertyFromApplicationPropertiesFile;
    private String ymlCustomProp;

    public String getYmlCustomProp() {
        return ymlCustomProp;
    }

    public void setYmlCustomProp(String ymlCustomProp) {
        this.ymlCustomProp = ymlCustomProp;
    }

    public String getCustomPropertyFromApplicationPropertiesFile() {
        return customPropertyFromApplicationPropertiesFile;
    }

    public void setCustomPropertyFromApplicationPropertiesFile(String customPropertyFromApplicationPropertiesFile) {
        this.customPropertyFromApplicationPropertiesFile = customPropertyFromApplicationPropertiesFile;
    }

    public String getJavaHomePath() {
        return javaHomePath;
    }

    public void setJavaHomePath(String javaHomePath) {
        this.javaHomePath = javaHomePath;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "FakeDataSource{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", url='" + url + '\'' +
                ", javaHomePath='" + javaHomePath + '\'' +
                ", customPropertyFromApplicationPropertiesFile='" + customPropertyFromApplicationPropertiesFile + '\'' +
                ", ymlCustomProp='" + ymlCustomProp + '\'' +
                '}';
    }
}
