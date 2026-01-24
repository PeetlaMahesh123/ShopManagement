package com.Shop.ShopManagement;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class UserDAO {

    private static final SessionFactory factory =
            new Configuration().configure().buildSessionFactory();

    // ================= ADMIN LOGIN =================
    public static boolean validateAdmin(String username, String password) {

        try (Session session = factory.openSession()) {

            String sql =
                "SELECT * FROM users " +
                "WHERE username = :u AND password = :p AND role = 'ADMIN'";

            NativeQuery<User> query =
                    session.createNativeQuery(sql, User.class);

            query.setParameter("u", username);
            query.setParameter("p", password);

            return query.uniqueResult() != null;
        }
    }

    // ================= ADD USER =================
    public static void addUser(User user) {

        Transaction tx = null;
        try (Session session = factory.openSession()) {

            tx = session.beginTransaction();

            String sql =
                "INSERT INTO users (username, password, age, role) " +
                "VALUES (:u, :p, :a, :r)";

            NativeQuery<?> query = session.createNativeQuery(sql);
            query.setParameter("u", user.getUsername());
            query.setParameter("p", user.getPassword());
            query.setParameter("a", user.getAge());
            query.setParameter("r", user.getRole().name());

            query.executeUpdate();
            tx.commit();
        }
    }

    // ================= DISPLAY USERS =================
    public static List<User> getAllUsers() {

        try (Session session = factory.openSession()) {

            String sql = "SELECT * FROM users";

            NativeQuery<User> query =
                    session.createNativeQuery(sql, User.class);

            return query.list();
        }
    }

    // ================= DELETE USER =================
    public static void deleteUser(int uid) {

        Transaction tx = null;
        try (Session session = factory.openSession()) {

            tx = session.beginTransaction();

            String sql = "DELETE FROM users WHERE uid = :id";

            NativeQuery<?> query = session.createNativeQuery(sql);
            query.setParameter("id", uid);

            query.executeUpdate();
            tx.commit();
        }
    }

    // ================= UPDATE USERNAME =================
    public static void updateUsername(int uid, String username) {
        updateField(uid, "username", username);
    }

    // ================= UPDATE PASSWORD =================
    public static void updatePassword(int uid, String password) {
        updateField(uid, "password", password);
    }

    // ================= UPDATE AGE =================
    public static void updateAge(int uid, int age) {
        updateField(uid, "age", age);
    }

    // ================= UPDATE ROLE =================
    public static void updateRole(int uid, Role role) {
        updateField(uid, "role", role.name());
    }

    // ================= COMMON UPDATE =================
    private static void updateField(int uid, String column, Object value) {

        Transaction tx = null;
        try (Session session = factory.openSession()) {

            tx = session.beginTransaction();

            String sql =
                "UPDATE users SET " + column + " = :val WHERE uid = :id";

            NativeQuery<?> query = session.createNativeQuery(sql);
            query.setParameter("val", value);
            query.setParameter("id", uid);

            query.executeUpdate();
            tx.commit();
        }
    }
}
