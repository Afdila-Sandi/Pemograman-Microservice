package com.tekologiinformasi.restfulapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "voucher")
public class Voucher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String kode_voucher;
    private String diskon;
    private String deskripsi;

    // Constructor tanpa parameter
    public Voucher() {}

    // Constructor dengan parameter
    public Voucher(String kode_voucher, String diskon, String deskripsi) {
        this.kode_voucher = kode_voucher;
        this.diskon = diskon;
        this.deskripsi = deskripsi;
    }

    // Getters dan Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKodeVoucher() {
        return kode_voucher;
    }

    public void setKodeVoucher(String kode_voucher) {
        this.kode_voucher = kode_voucher;
    }

    public String getDiskon() {
        return diskon;
    }

    public void setDiskon(String diskon) {
        this.diskon = diskon;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}
