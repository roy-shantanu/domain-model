package com.company.domain;

import java.io.Serializable;

/**
 * User: Shantanu Roy
 * Date: 03-Nov-17
 * Time: 6:40 PM
 */
public abstract class BaseEntity implements Serializable {

    public abstract Long getId();

    public abstract void setId(Long id);
}