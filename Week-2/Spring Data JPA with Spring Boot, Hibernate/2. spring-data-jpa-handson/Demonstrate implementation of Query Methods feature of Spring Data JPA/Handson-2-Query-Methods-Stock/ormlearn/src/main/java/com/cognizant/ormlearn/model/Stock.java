package com.cognizant.ormlearn.model;
import java.math.BigDecimal;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
@Entity
@Table(name = "stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "st_id")
    private int id;
    @Column(name = "st_code")
    private String code;
    @Column(name = "st_date", columnDefinition = "DATE")
    @Temporal(jakarta.persistence.TemporalType.DATE)
    private Date date;
    @Column(name = "st_open")
    private BigDecimal open;
    @Column(name = "st_close")
    private BigDecimal close;
    @Column(name = "st_volume")
    private long volume;
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
    public BigDecimal getOpen() { return open; }
    public void setOpen(BigDecimal open) { this.open = open; }
    public BigDecimal getClose() { return close; }
    public void setClose(BigDecimal close) { this.close = close; }
    public long getVolume() { return volume; }
    public void setVolume(long volume) { this.volume = volume; }
    @Override
    public String toString() {
        return "Stock [code=" + code + ", date=" + date +
               ", open=" + open + ", close=" + close +
               ", volume=" + volume + "]";
    }
}