package com.Shop.ShopManagement;

import java.util.List;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class ProductDAO {

    private static final SessionFactory factory =
            new Configuration().configure().buildSessionFactory();

    // ================= ADD PRODUCT =================
    public static void addProduct(Product p) {
        Transaction tx = null;
        try (Session s = factory.openSession()) {
            tx = s.beginTransaction();

            String sql =
                "INSERT INTO product (pname, price, description, category, productImageurl) " +
                "VALUES (:n, :p, :d, :c, :i)";

            NativeQuery<?> q = s.createNativeQuery(sql);
            q.setParameter("n", p.getPname());
            q.setParameter("p", p.getPrice());
            q.setParameter("d", p.getDescription());
            q.setParameter("c", p.getCategory());
            q.setParameter("i", p.getProductImageurl());

            q.executeUpdate();
            tx.commit();
        }
    }

    // ================= DISPLAY PRODUCTS =================
    public static List<Product> getAllProducts() {
        try (Session s = factory.openSession()) {
            return s.createNativeQuery(
                "SELECT * FROM product", Product.class
            ).list();
        }
    }

    // ================= DELETE PRODUCT =================
    public static void deleteProduct(int pid) {
        Transaction tx = null;
        try (Session s = factory.openSession()) {
            tx = s.beginTransaction();
            s.createNativeQuery(
                "DELETE FROM product WHERE pid = :id"
            ).setParameter("id", pid).executeUpdate();
            tx.commit();
        }
    }

    // ================= UPDATE METHODS =================
    public static void updateName(int pid, String val) {
        update(pid, "pname", val);
    }

    public static void updatePrice(int pid, double val) {
        update(pid, "price", val);
    }

    public static void updateDescription(int pid, String val) {
        update(pid, "description", val);
    }

    public static void updateCategory(int pid, String val) {
        update(pid, "category", val);
    }

    public static void updateImage(int pid, String val) {
        update(pid, "productImageurl", val);
    }

    private static void update(int pid, String col, Object val) {
        Transaction tx = null;
        try (Session s = factory.openSession()) {
            tx = s.beginTransaction();

            String sql =
                "UPDATE product SET " + col + " = :v WHERE pid = :id";

            s.createNativeQuery(sql)
             .setParameter("v", val)
             .setParameter("id", pid)
             .executeUpdate();

            tx.commit();
        }
    }
}
