package com.tangwh.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author  Tangweihao
 * @date  2019/12/29 13:14
 * @version 1.0
 */
@Data
@NoArgsConstructor
public class Politicsstatus implements Serializable {
    /**
    * 
    */
    private Integer id;

    /**
    * 
    */
    private String name;

    public Politicsstatus(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}

        if (o == null || getClass() != o.getClass()) {return false;}
        Politicsstatus that = (Politicsstatus) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}