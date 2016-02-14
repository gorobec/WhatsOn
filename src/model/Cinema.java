package model;

public class Cinema implements Comparable<Cinema>{
    private final int cityId;
    private final String name;
    private final String address;
    private final String phone;
    private final String url;

    @Override
    public int compareTo(Cinema cinema) {
        return this.name.compareTo(cinema.name);
    }

    public static class Builder {
        private int cityId;
        private String name;
        private String address;
        private String phone;
        private String url;

        public Builder cityId(int cityId){
            this.cityId = cityId;
            return this;
        }
        public Builder name(String name){
            this.name = name;
            return this;
        }
        public Builder address(String address){
            this.address = address;
            return this;
        }
        public Builder phone(String phone){
            this.phone = phone;
            return this;
        }
        public Builder url(String url){
            this.url = url;
            return this;
        }
        public Cinema build(){
            return new Cinema(this);
        }
    }
    private Cinema(Builder builder){
        cityId = builder.cityId;
        name = builder.name;
        address = builder.address;
        phone = builder.phone;
        url = builder.url;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "cityId=" + cityId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
