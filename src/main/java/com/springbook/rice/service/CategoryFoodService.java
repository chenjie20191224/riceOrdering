package com.springbook.rice.service;


import com.springbook.rice.common.domain.CategoryFood;
import com.springbook.rice.common.utils.JSONResult;

import java.util.List;

public interface CategoryFoodService {
    List<CategoryFood> selectAll();
    JSONResult categoryDwon(String category);
    JSONResult categoryUp(String category);
    JSONResult categoryDelete(String category);
    JSONResult categoryAdd(String category);

}
