package com.basung.ecommerce.common.controller;

import java.util.List;

public interface PagingList<T> extends List<T> {
    int getTotalCount();
}
