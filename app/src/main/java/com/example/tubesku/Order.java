package com.example.tubesku;

public class Order {
    private String _id, _nama, _pesan, _level;
    public Order (String id, String nama, String pesan, String level) {
        this._id = id;
        this._nama = nama;
        this._pesan = pesan;
        this._level = level;
    }
    public Order() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_nama() {
        return _nama;
    }
    public void set_nama(String _nama) {
        this._nama = _nama;
    }
    public String get_pesan() {
        return _pesan;
    }
    public void set_pesan(String _pesan) {
        this._pesan = _pesan;
    }
    public String get_level() {
        return _level;
    }
    public void set_level(String _level) {
        this._level = _level;
    }
}
