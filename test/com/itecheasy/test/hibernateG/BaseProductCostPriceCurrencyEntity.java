package com.itecheasy.test.hibernateG;

import javax.persistence.*;

@Entity
@Table(name = "base_product_cost_price_currency", schema = "dbo", catalog = "Develop_OSMS")
public class BaseProductCostPriceCurrencyEntity {
    private int id;
    private Integer currency;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "currency", nullable = true)
    public Integer getCurrency() {
        return currency;
    }

    public void setCurrency(Integer currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseProductCostPriceCurrencyEntity that = (BaseProductCostPriceCurrencyEntity) o;

        if (id != that.id) return false;
        if (currency != null ? !currency.equals(that.currency) : that.currency != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        return result;
    }
}
