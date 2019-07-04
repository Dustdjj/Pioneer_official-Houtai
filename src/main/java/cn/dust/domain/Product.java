package cn.dust.domain;

public class Product {
    private int productId;
    private String productName;
    private String productDescription;
    private String productImg;
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }


    public Product(String productName, String productDescription, String productImg) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productImg = productImg;
    }

    public Product(int productId, String productName, String productDescription, String productImg) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productImg = productImg;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productImg='" + productImg + '\'' +
                '}';
    }
}
