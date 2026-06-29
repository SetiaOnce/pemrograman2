-- ==============================================
-- ServletMVCLogin — Database Schema
-- Database : SQLite (app.db)
-- Lokasi   : C:\Users\<username>\ServletMVCLogin\app.db
-- ==============================================

-- Tabel users — menyimpan data login
CREATE TABLE IF NOT EXISTS users (
    id       INTEGER PRIMARY KEY AUTOINCREMENT,
    username TEXT    NOT NULL UNIQUE,
    password TEXT    NOT NULL,
    fullname TEXT    NOT NULL,
    role     TEXT    NOT NULL
);

-- Data default admin
INSERT OR IGNORE INTO users (username, password, fullname, role)
VALUES ('admin', 'admin123', 'Administrator', 'Admin');
