package com.springbook.rice.common.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderFoodExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderFoodExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("order_id like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("order_id not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderStateIsNull() {
            addCriterion("order_state is null");
            return (Criteria) this;
        }

        public Criteria andOrderStateIsNotNull() {
            addCriterion("order_state is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStateEqualTo(String value) {
            addCriterion("order_state =", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateNotEqualTo(String value) {
            addCriterion("order_state <>", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateGreaterThan(String value) {
            addCriterion("order_state >", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateGreaterThanOrEqualTo(String value) {
            addCriterion("order_state >=", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateLessThan(String value) {
            addCriterion("order_state <", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateLessThanOrEqualTo(String value) {
            addCriterion("order_state <=", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateLike(String value) {
            addCriterion("order_state like", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateNotLike(String value) {
            addCriterion("order_state not like", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateIn(List<String> values) {
            addCriterion("order_state in", values, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateNotIn(List<String> values) {
            addCriterion("order_state not in", values, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateBetween(String value1, String value2) {
            addCriterion("order_state between", value1, value2, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateNotBetween(String value1, String value2) {
            addCriterion("order_state not between", value1, value2, "orderState");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNull() {
            addCriterion("telephone is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNotNull() {
            addCriterion("telephone is not null");
            return (Criteria) this;
        }

        public Criteria andTelephoneEqualTo(String value) {
            addCriterion("telephone =", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotEqualTo(String value) {
            addCriterion("telephone <>", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThan(String value) {
            addCriterion("telephone >", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("telephone >=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThan(String value) {
            addCriterion("telephone <", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThanOrEqualTo(String value) {
            addCriterion("telephone <=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLike(String value) {
            addCriterion("telephone like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotLike(String value) {
            addCriterion("telephone not like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneIn(List<String> values) {
            addCriterion("telephone in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotIn(List<String> values) {
            addCriterion("telephone not in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneBetween(String value1, String value2) {
            addCriterion("telephone between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotBetween(String value1, String value2) {
            addCriterion("telephone not between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNull() {
            addCriterion("total_price is null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNotNull() {
            addCriterion("total_price is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceEqualTo(BigDecimal value) {
            addCriterion("total_price =", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotEqualTo(BigDecimal value) {
            addCriterion("total_price <>", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThan(BigDecimal value) {
            addCriterion("total_price >", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_price >=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThan(BigDecimal value) {
            addCriterion("total_price <", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_price <=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIn(List<BigDecimal> values) {
            addCriterion("total_price in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotIn(List<BigDecimal> values) {
            addCriterion("total_price not in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_price between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_price not between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andTablewareQuantityIsNull() {
            addCriterion("tableware_quantity is null");
            return (Criteria) this;
        }

        public Criteria andTablewareQuantityIsNotNull() {
            addCriterion("tableware_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andTablewareQuantityEqualTo(String value) {
            addCriterion("tableware_quantity =", value, "tablewareQuantity");
            return (Criteria) this;
        }

        public Criteria andTablewareQuantityNotEqualTo(String value) {
            addCriterion("tableware_quantity <>", value, "tablewareQuantity");
            return (Criteria) this;
        }

        public Criteria andTablewareQuantityGreaterThan(String value) {
            addCriterion("tableware_quantity >", value, "tablewareQuantity");
            return (Criteria) this;
        }

        public Criteria andTablewareQuantityGreaterThanOrEqualTo(String value) {
            addCriterion("tableware_quantity >=", value, "tablewareQuantity");
            return (Criteria) this;
        }

        public Criteria andTablewareQuantityLessThan(String value) {
            addCriterion("tableware_quantity <", value, "tablewareQuantity");
            return (Criteria) this;
        }

        public Criteria andTablewareQuantityLessThanOrEqualTo(String value) {
            addCriterion("tableware_quantity <=", value, "tablewareQuantity");
            return (Criteria) this;
        }

        public Criteria andTablewareQuantityLike(String value) {
            addCriterion("tableware_quantity like", value, "tablewareQuantity");
            return (Criteria) this;
        }

        public Criteria andTablewareQuantityNotLike(String value) {
            addCriterion("tableware_quantity not like", value, "tablewareQuantity");
            return (Criteria) this;
        }

        public Criteria andTablewareQuantityIn(List<String> values) {
            addCriterion("tableware_quantity in", values, "tablewareQuantity");
            return (Criteria) this;
        }

        public Criteria andTablewareQuantityNotIn(List<String> values) {
            addCriterion("tableware_quantity not in", values, "tablewareQuantity");
            return (Criteria) this;
        }

        public Criteria andTablewareQuantityBetween(String value1, String value2) {
            addCriterion("tableware_quantity between", value1, value2, "tablewareQuantity");
            return (Criteria) this;
        }

        public Criteria andTablewareQuantityNotBetween(String value1, String value2) {
            addCriterion("tableware_quantity not between", value1, value2, "tablewareQuantity");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeIsNull() {
            addCriterion("delivery_time is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeIsNotNull() {
            addCriterion("delivery_time is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeEqualTo(String value) {
            addCriterion("delivery_time =", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeNotEqualTo(String value) {
            addCriterion("delivery_time <>", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeGreaterThan(String value) {
            addCriterion("delivery_time >", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeGreaterThanOrEqualTo(String value) {
            addCriterion("delivery_time >=", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeLessThan(String value) {
            addCriterion("delivery_time <", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeLessThanOrEqualTo(String value) {
            addCriterion("delivery_time <=", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeLike(String value) {
            addCriterion("delivery_time like", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeNotLike(String value) {
            addCriterion("delivery_time not like", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeIn(List<String> values) {
            addCriterion("delivery_time in", values, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeNotIn(List<String> values) {
            addCriterion("delivery_time not in", values, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeBetween(String value1, String value2) {
            addCriterion("delivery_time between", value1, value2, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeNotBetween(String value1, String value2) {
            addCriterion("delivery_time not between", value1, value2, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIsNull() {
            addCriterion("order_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIsNotNull() {
            addCriterion("order_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeEqualTo(String value) {
            addCriterion("order_time =", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotEqualTo(String value) {
            addCriterion("order_time <>", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThan(String value) {
            addCriterion("order_time >", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThanOrEqualTo(String value) {
            addCriterion("order_time >=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThan(String value) {
            addCriterion("order_time <", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThanOrEqualTo(String value) {
            addCriterion("order_time <=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLike(String value) {
            addCriterion("order_time like", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotLike(String value) {
            addCriterion("order_time not like", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIn(List<String> values) {
            addCriterion("order_time in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotIn(List<String> values) {
            addCriterion("order_time not in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeBetween(String value1, String value2) {
            addCriterion("order_time between", value1, value2, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotBetween(String value1, String value2) {
            addCriterion("order_time not between", value1, value2, "orderTime");
            return (Criteria) this;
        }

        public Criteria andPackFeeIsNull() {
            addCriterion("pack_fee is null");
            return (Criteria) this;
        }

        public Criteria andPackFeeIsNotNull() {
            addCriterion("pack_fee is not null");
            return (Criteria) this;
        }

        public Criteria andPackFeeEqualTo(BigDecimal value) {
            addCriterion("pack_fee =", value, "packFee");
            return (Criteria) this;
        }

        public Criteria andPackFeeNotEqualTo(BigDecimal value) {
            addCriterion("pack_fee <>", value, "packFee");
            return (Criteria) this;
        }

        public Criteria andPackFeeGreaterThan(BigDecimal value) {
            addCriterion("pack_fee >", value, "packFee");
            return (Criteria) this;
        }

        public Criteria andPackFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pack_fee >=", value, "packFee");
            return (Criteria) this;
        }

        public Criteria andPackFeeLessThan(BigDecimal value) {
            addCriterion("pack_fee <", value, "packFee");
            return (Criteria) this;
        }

        public Criteria andPackFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("pack_fee <=", value, "packFee");
            return (Criteria) this;
        }

        public Criteria andPackFeeIn(List<BigDecimal> values) {
            addCriterion("pack_fee in", values, "packFee");
            return (Criteria) this;
        }

        public Criteria andPackFeeNotIn(List<BigDecimal> values) {
            addCriterion("pack_fee not in", values, "packFee");
            return (Criteria) this;
        }

        public Criteria andPackFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pack_fee between", value1, value2, "packFee");
            return (Criteria) this;
        }

        public Criteria andPackFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pack_fee not between", value1, value2, "packFee");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeIsNull() {
            addCriterion("delivery_fee is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeIsNotNull() {
            addCriterion("delivery_fee is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeEqualTo(BigDecimal value) {
            addCriterion("delivery_fee =", value, "deliveryFee");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeNotEqualTo(BigDecimal value) {
            addCriterion("delivery_fee <>", value, "deliveryFee");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeGreaterThan(BigDecimal value) {
            addCriterion("delivery_fee >", value, "deliveryFee");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("delivery_fee >=", value, "deliveryFee");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeLessThan(BigDecimal value) {
            addCriterion("delivery_fee <", value, "deliveryFee");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("delivery_fee <=", value, "deliveryFee");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeIn(List<BigDecimal> values) {
            addCriterion("delivery_fee in", values, "deliveryFee");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeNotIn(List<BigDecimal> values) {
            addCriterion("delivery_fee not in", values, "deliveryFee");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("delivery_fee between", value1, value2, "deliveryFee");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("delivery_fee not between", value1, value2, "deliveryFee");
            return (Criteria) this;
        }

        public Criteria andActualPayIsNull() {
            addCriterion("actual_pay is null");
            return (Criteria) this;
        }

        public Criteria andActualPayIsNotNull() {
            addCriterion("actual_pay is not null");
            return (Criteria) this;
        }

        public Criteria andActualPayEqualTo(BigDecimal value) {
            addCriterion("actual_pay =", value, "actualPay");
            return (Criteria) this;
        }

        public Criteria andActualPayNotEqualTo(BigDecimal value) {
            addCriterion("actual_pay <>", value, "actualPay");
            return (Criteria) this;
        }

        public Criteria andActualPayGreaterThan(BigDecimal value) {
            addCriterion("actual_pay >", value, "actualPay");
            return (Criteria) this;
        }

        public Criteria andActualPayGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("actual_pay >=", value, "actualPay");
            return (Criteria) this;
        }

        public Criteria andActualPayLessThan(BigDecimal value) {
            addCriterion("actual_pay <", value, "actualPay");
            return (Criteria) this;
        }

        public Criteria andActualPayLessThanOrEqualTo(BigDecimal value) {
            addCriterion("actual_pay <=", value, "actualPay");
            return (Criteria) this;
        }

        public Criteria andActualPayIn(List<BigDecimal> values) {
            addCriterion("actual_pay in", values, "actualPay");
            return (Criteria) this;
        }

        public Criteria andActualPayNotIn(List<BigDecimal> values) {
            addCriterion("actual_pay not in", values, "actualPay");
            return (Criteria) this;
        }

        public Criteria andActualPayBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("actual_pay between", value1, value2, "actualPay");
            return (Criteria) this;
        }

        public Criteria andActualPayNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("actual_pay not between", value1, value2, "actualPay");
            return (Criteria) this;
        }

        public Criteria andOpenidIsNull() {
            addCriterion("openid is null");
            return (Criteria) this;
        }

        public Criteria andOpenidIsNotNull() {
            addCriterion("openid is not null");
            return (Criteria) this;
        }

        public Criteria andOpenidEqualTo(String value) {
            addCriterion("openid =", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotEqualTo(String value) {
            addCriterion("openid <>", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidGreaterThan(String value) {
            addCriterion("openid >", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("openid >=", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLessThan(String value) {
            addCriterion("openid <", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLessThanOrEqualTo(String value) {
            addCriterion("openid <=", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLike(String value) {
            addCriterion("openid like", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotLike(String value) {
            addCriterion("openid not like", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidIn(List<String> values) {
            addCriterion("openid in", values, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotIn(List<String> values) {
            addCriterion("openid not in", values, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidBetween(String value1, String value2) {
            addCriterion("openid between", value1, value2, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotBetween(String value1, String value2) {
            addCriterion("openid not between", value1, value2, "openid");
            return (Criteria) this;
        }

        public Criteria andFoodNumIsNull() {
            addCriterion("food_num is null");
            return (Criteria) this;
        }

        public Criteria andFoodNumIsNotNull() {
            addCriterion("food_num is not null");
            return (Criteria) this;
        }

        public Criteria andFoodNumEqualTo(Integer value) {
            addCriterion("food_num =", value, "foodNum");
            return (Criteria) this;
        }

        public Criteria andFoodNumNotEqualTo(Integer value) {
            addCriterion("food_num <>", value, "foodNum");
            return (Criteria) this;
        }

        public Criteria andFoodNumGreaterThan(Integer value) {
            addCriterion("food_num >", value, "foodNum");
            return (Criteria) this;
        }

        public Criteria andFoodNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("food_num >=", value, "foodNum");
            return (Criteria) this;
        }

        public Criteria andFoodNumLessThan(Integer value) {
            addCriterion("food_num <", value, "foodNum");
            return (Criteria) this;
        }

        public Criteria andFoodNumLessThanOrEqualTo(Integer value) {
            addCriterion("food_num <=", value, "foodNum");
            return (Criteria) this;
        }

        public Criteria andFoodNumIn(List<Integer> values) {
            addCriterion("food_num in", values, "foodNum");
            return (Criteria) this;
        }

        public Criteria andFoodNumNotIn(List<Integer> values) {
            addCriterion("food_num not in", values, "foodNum");
            return (Criteria) this;
        }

        public Criteria andFoodNumBetween(Integer value1, Integer value2) {
            addCriterion("food_num between", value1, value2, "foodNum");
            return (Criteria) this;
        }

        public Criteria andFoodNumNotBetween(Integer value1, Integer value2) {
            addCriterion("food_num not between", value1, value2, "foodNum");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}