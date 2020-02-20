package com.springbook.rice.common.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BusinessExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BusinessExample() {
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

        public Criteria andBusinessIdIsNull() {
            addCriterion("business_id is null");
            return (Criteria) this;
        }

        public Criteria andBusinessIdIsNotNull() {
            addCriterion("business_id is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessIdEqualTo(Integer value) {
            addCriterion("business_id =", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdNotEqualTo(Integer value) {
            addCriterion("business_id <>", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdGreaterThan(Integer value) {
            addCriterion("business_id >", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("business_id >=", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdLessThan(Integer value) {
            addCriterion("business_id <", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdLessThanOrEqualTo(Integer value) {
            addCriterion("business_id <=", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdIn(List<Integer> values) {
            addCriterion("business_id in", values, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdNotIn(List<Integer> values) {
            addCriterion("business_id not in", values, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdBetween(Integer value1, Integer value2) {
            addCriterion("business_id between", value1, value2, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdNotBetween(Integer value1, Integer value2) {
            addCriterion("business_id not between", value1, value2, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessNameIsNull() {
            addCriterion("business_name is null");
            return (Criteria) this;
        }

        public Criteria andBusinessNameIsNotNull() {
            addCriterion("business_name is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessNameEqualTo(String value) {
            addCriterion("business_name =", value, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameNotEqualTo(String value) {
            addCriterion("business_name <>", value, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameGreaterThan(String value) {
            addCriterion("business_name >", value, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameGreaterThanOrEqualTo(String value) {
            addCriterion("business_name >=", value, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameLessThan(String value) {
            addCriterion("business_name <", value, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameLessThanOrEqualTo(String value) {
            addCriterion("business_name <=", value, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameLike(String value) {
            addCriterion("business_name like", value, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameNotLike(String value) {
            addCriterion("business_name not like", value, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameIn(List<String> values) {
            addCriterion("business_name in", values, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameNotIn(List<String> values) {
            addCriterion("business_name not in", values, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameBetween(String value1, String value2) {
            addCriterion("business_name between", value1, value2, "businessName");
            return (Criteria) this;
        }

        public Criteria andBusinessNameNotBetween(String value1, String value2) {
            addCriterion("business_name not between", value1, value2, "businessName");
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

        public Criteria andActivityIsNull() {
            addCriterion("activity is null");
            return (Criteria) this;
        }

        public Criteria andActivityIsNotNull() {
            addCriterion("activity is not null");
            return (Criteria) this;
        }

        public Criteria andActivityEqualTo(String value) {
            addCriterion("activity =", value, "activity");
            return (Criteria) this;
        }

        public Criteria andActivityNotEqualTo(String value) {
            addCriterion("activity <>", value, "activity");
            return (Criteria) this;
        }

        public Criteria andActivityGreaterThan(String value) {
            addCriterion("activity >", value, "activity");
            return (Criteria) this;
        }

        public Criteria andActivityGreaterThanOrEqualTo(String value) {
            addCriterion("activity >=", value, "activity");
            return (Criteria) this;
        }

        public Criteria andActivityLessThan(String value) {
            addCriterion("activity <", value, "activity");
            return (Criteria) this;
        }

        public Criteria andActivityLessThanOrEqualTo(String value) {
            addCriterion("activity <=", value, "activity");
            return (Criteria) this;
        }

        public Criteria andActivityLike(String value) {
            addCriterion("activity like", value, "activity");
            return (Criteria) this;
        }

        public Criteria andActivityNotLike(String value) {
            addCriterion("activity not like", value, "activity");
            return (Criteria) this;
        }

        public Criteria andActivityIn(List<String> values) {
            addCriterion("activity in", values, "activity");
            return (Criteria) this;
        }

        public Criteria andActivityNotIn(List<String> values) {
            addCriterion("activity not in", values, "activity");
            return (Criteria) this;
        }

        public Criteria andActivityBetween(String value1, String value2) {
            addCriterion("activity between", value1, value2, "activity");
            return (Criteria) this;
        }

        public Criteria andActivityNotBetween(String value1, String value2) {
            addCriterion("activity not between", value1, value2, "activity");
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

        public Criteria andDeliveryScopeIsNull() {
            addCriterion("delivery_scope is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryScopeIsNotNull() {
            addCriterion("delivery_scope is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryScopeEqualTo(Integer value) {
            addCriterion("delivery_scope =", value, "deliveryScope");
            return (Criteria) this;
        }

        public Criteria andDeliveryScopeNotEqualTo(Integer value) {
            addCriterion("delivery_scope <>", value, "deliveryScope");
            return (Criteria) this;
        }

        public Criteria andDeliveryScopeGreaterThan(Integer value) {
            addCriterion("delivery_scope >", value, "deliveryScope");
            return (Criteria) this;
        }

        public Criteria andDeliveryScopeGreaterThanOrEqualTo(Integer value) {
            addCriterion("delivery_scope >=", value, "deliveryScope");
            return (Criteria) this;
        }

        public Criteria andDeliveryScopeLessThan(Integer value) {
            addCriterion("delivery_scope <", value, "deliveryScope");
            return (Criteria) this;
        }

        public Criteria andDeliveryScopeLessThanOrEqualTo(Integer value) {
            addCriterion("delivery_scope <=", value, "deliveryScope");
            return (Criteria) this;
        }

        public Criteria andDeliveryScopeIn(List<Integer> values) {
            addCriterion("delivery_scope in", values, "deliveryScope");
            return (Criteria) this;
        }

        public Criteria andDeliveryScopeNotIn(List<Integer> values) {
            addCriterion("delivery_scope not in", values, "deliveryScope");
            return (Criteria) this;
        }

        public Criteria andDeliveryScopeBetween(Integer value1, Integer value2) {
            addCriterion("delivery_scope between", value1, value2, "deliveryScope");
            return (Criteria) this;
        }

        public Criteria andDeliveryScopeNotBetween(Integer value1, Integer value2) {
            addCriterion("delivery_scope not between", value1, value2, "deliveryScope");
            return (Criteria) this;
        }

        public Criteria andChart1IsNull() {
            addCriterion("chart_1 is null");
            return (Criteria) this;
        }

        public Criteria andChart1IsNotNull() {
            addCriterion("chart_1 is not null");
            return (Criteria) this;
        }

        public Criteria andChart1EqualTo(String value) {
            addCriterion("chart_1 =", value, "chart1");
            return (Criteria) this;
        }

        public Criteria andChart1NotEqualTo(String value) {
            addCriterion("chart_1 <>", value, "chart1");
            return (Criteria) this;
        }

        public Criteria andChart1GreaterThan(String value) {
            addCriterion("chart_1 >", value, "chart1");
            return (Criteria) this;
        }

        public Criteria andChart1GreaterThanOrEqualTo(String value) {
            addCriterion("chart_1 >=", value, "chart1");
            return (Criteria) this;
        }

        public Criteria andChart1LessThan(String value) {
            addCriterion("chart_1 <", value, "chart1");
            return (Criteria) this;
        }

        public Criteria andChart1LessThanOrEqualTo(String value) {
            addCriterion("chart_1 <=", value, "chart1");
            return (Criteria) this;
        }

        public Criteria andChart1Like(String value) {
            addCriterion("chart_1 like", value, "chart1");
            return (Criteria) this;
        }

        public Criteria andChart1NotLike(String value) {
            addCriterion("chart_1 not like", value, "chart1");
            return (Criteria) this;
        }

        public Criteria andChart1In(List<String> values) {
            addCriterion("chart_1 in", values, "chart1");
            return (Criteria) this;
        }

        public Criteria andChart1NotIn(List<String> values) {
            addCriterion("chart_1 not in", values, "chart1");
            return (Criteria) this;
        }

        public Criteria andChart1Between(String value1, String value2) {
            addCriterion("chart_1 between", value1, value2, "chart1");
            return (Criteria) this;
        }

        public Criteria andChart1NotBetween(String value1, String value2) {
            addCriterion("chart_1 not between", value1, value2, "chart1");
            return (Criteria) this;
        }

        public Criteria andChart2IsNull() {
            addCriterion("chart_2 is null");
            return (Criteria) this;
        }

        public Criteria andChart2IsNotNull() {
            addCriterion("chart_2 is not null");
            return (Criteria) this;
        }

        public Criteria andChart2EqualTo(String value) {
            addCriterion("chart_2 =", value, "chart2");
            return (Criteria) this;
        }

        public Criteria andChart2NotEqualTo(String value) {
            addCriterion("chart_2 <>", value, "chart2");
            return (Criteria) this;
        }

        public Criteria andChart2GreaterThan(String value) {
            addCriterion("chart_2 >", value, "chart2");
            return (Criteria) this;
        }

        public Criteria andChart2GreaterThanOrEqualTo(String value) {
            addCriterion("chart_2 >=", value, "chart2");
            return (Criteria) this;
        }

        public Criteria andChart2LessThan(String value) {
            addCriterion("chart_2 <", value, "chart2");
            return (Criteria) this;
        }

        public Criteria andChart2LessThanOrEqualTo(String value) {
            addCriterion("chart_2 <=", value, "chart2");
            return (Criteria) this;
        }

        public Criteria andChart2Like(String value) {
            addCriterion("chart_2 like", value, "chart2");
            return (Criteria) this;
        }

        public Criteria andChart2NotLike(String value) {
            addCriterion("chart_2 not like", value, "chart2");
            return (Criteria) this;
        }

        public Criteria andChart2In(List<String> values) {
            addCriterion("chart_2 in", values, "chart2");
            return (Criteria) this;
        }

        public Criteria andChart2NotIn(List<String> values) {
            addCriterion("chart_2 not in", values, "chart2");
            return (Criteria) this;
        }

        public Criteria andChart2Between(String value1, String value2) {
            addCriterion("chart_2 between", value1, value2, "chart2");
            return (Criteria) this;
        }

        public Criteria andChart2NotBetween(String value1, String value2) {
            addCriterion("chart_2 not between", value1, value2, "chart2");
            return (Criteria) this;
        }

        public Criteria andChart3IsNull() {
            addCriterion("chart_3 is null");
            return (Criteria) this;
        }

        public Criteria andChart3IsNotNull() {
            addCriterion("chart_3 is not null");
            return (Criteria) this;
        }

        public Criteria andChart3EqualTo(String value) {
            addCriterion("chart_3 =", value, "chart3");
            return (Criteria) this;
        }

        public Criteria andChart3NotEqualTo(String value) {
            addCriterion("chart_3 <>", value, "chart3");
            return (Criteria) this;
        }

        public Criteria andChart3GreaterThan(String value) {
            addCriterion("chart_3 >", value, "chart3");
            return (Criteria) this;
        }

        public Criteria andChart3GreaterThanOrEqualTo(String value) {
            addCriterion("chart_3 >=", value, "chart3");
            return (Criteria) this;
        }

        public Criteria andChart3LessThan(String value) {
            addCriterion("chart_3 <", value, "chart3");
            return (Criteria) this;
        }

        public Criteria andChart3LessThanOrEqualTo(String value) {
            addCriterion("chart_3 <=", value, "chart3");
            return (Criteria) this;
        }

        public Criteria andChart3Like(String value) {
            addCriterion("chart_3 like", value, "chart3");
            return (Criteria) this;
        }

        public Criteria andChart3NotLike(String value) {
            addCriterion("chart_3 not like", value, "chart3");
            return (Criteria) this;
        }

        public Criteria andChart3In(List<String> values) {
            addCriterion("chart_3 in", values, "chart3");
            return (Criteria) this;
        }

        public Criteria andChart3NotIn(List<String> values) {
            addCriterion("chart_3 not in", values, "chart3");
            return (Criteria) this;
        }

        public Criteria andChart3Between(String value1, String value2) {
            addCriterion("chart_3 between", value1, value2, "chart3");
            return (Criteria) this;
        }

        public Criteria andChart3NotBetween(String value1, String value2) {
            addCriterion("chart_3 not between", value1, value2, "chart3");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseIsNull() {
            addCriterion("business_license is null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseIsNotNull() {
            addCriterion("business_license is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseEqualTo(String value) {
            addCriterion("business_license =", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotEqualTo(String value) {
            addCriterion("business_license <>", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseGreaterThan(String value) {
            addCriterion("business_license >", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseGreaterThanOrEqualTo(String value) {
            addCriterion("business_license >=", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseLessThan(String value) {
            addCriterion("business_license <", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseLessThanOrEqualTo(String value) {
            addCriterion("business_license <=", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseLike(String value) {
            addCriterion("business_license like", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotLike(String value) {
            addCriterion("business_license not like", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseIn(List<String> values) {
            addCriterion("business_license in", values, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotIn(List<String> values) {
            addCriterion("business_license not in", values, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseBetween(String value1, String value2) {
            addCriterion("business_license between", value1, value2, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotBetween(String value1, String value2) {
            addCriterion("business_license not between", value1, value2, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andStartDeliveryIsNull() {
            addCriterion("start_delivery is null");
            return (Criteria) this;
        }

        public Criteria andStartDeliveryIsNotNull() {
            addCriterion("start_delivery is not null");
            return (Criteria) this;
        }

        public Criteria andStartDeliveryEqualTo(Integer value) {
            addCriterion("start_delivery =", value, "startDelivery");
            return (Criteria) this;
        }

        public Criteria andStartDeliveryNotEqualTo(Integer value) {
            addCriterion("start_delivery <>", value, "startDelivery");
            return (Criteria) this;
        }

        public Criteria andStartDeliveryGreaterThan(Integer value) {
            addCriterion("start_delivery >", value, "startDelivery");
            return (Criteria) this;
        }

        public Criteria andStartDeliveryGreaterThanOrEqualTo(Integer value) {
            addCriterion("start_delivery >=", value, "startDelivery");
            return (Criteria) this;
        }

        public Criteria andStartDeliveryLessThan(Integer value) {
            addCriterion("start_delivery <", value, "startDelivery");
            return (Criteria) this;
        }

        public Criteria andStartDeliveryLessThanOrEqualTo(Integer value) {
            addCriterion("start_delivery <=", value, "startDelivery");
            return (Criteria) this;
        }

        public Criteria andStartDeliveryIn(List<Integer> values) {
            addCriterion("start_delivery in", values, "startDelivery");
            return (Criteria) this;
        }

        public Criteria andStartDeliveryNotIn(List<Integer> values) {
            addCriterion("start_delivery not in", values, "startDelivery");
            return (Criteria) this;
        }

        public Criteria andStartDeliveryBetween(Integer value1, Integer value2) {
            addCriterion("start_delivery between", value1, value2, "startDelivery");
            return (Criteria) this;
        }

        public Criteria andStartDeliveryNotBetween(Integer value1, Integer value2) {
            addCriterion("start_delivery not between", value1, value2, "startDelivery");
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

        public Criteria andDeliveryFeeEqualTo(Integer value) {
            addCriterion("delivery_fee =", value, "deliveryFee");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeNotEqualTo(Integer value) {
            addCriterion("delivery_fee <>", value, "deliveryFee");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeGreaterThan(Integer value) {
            addCriterion("delivery_fee >", value, "deliveryFee");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("delivery_fee >=", value, "deliveryFee");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeLessThan(Integer value) {
            addCriterion("delivery_fee <", value, "deliveryFee");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeLessThanOrEqualTo(Integer value) {
            addCriterion("delivery_fee <=", value, "deliveryFee");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeIn(List<Integer> values) {
            addCriterion("delivery_fee in", values, "deliveryFee");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeNotIn(List<Integer> values) {
            addCriterion("delivery_fee not in", values, "deliveryFee");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeBetween(Integer value1, Integer value2) {
            addCriterion("delivery_fee between", value1, value2, "deliveryFee");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeNotBetween(Integer value1, Integer value2) {
            addCriterion("delivery_fee not between", value1, value2, "deliveryFee");
            return (Criteria) this;
        }

        public Criteria andDeliveryServiceIsNull() {
            addCriterion("delivery_service is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryServiceIsNotNull() {
            addCriterion("delivery_service is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryServiceEqualTo(String value) {
            addCriterion("delivery_service =", value, "deliveryService");
            return (Criteria) this;
        }

        public Criteria andDeliveryServiceNotEqualTo(String value) {
            addCriterion("delivery_service <>", value, "deliveryService");
            return (Criteria) this;
        }

        public Criteria andDeliveryServiceGreaterThan(String value) {
            addCriterion("delivery_service >", value, "deliveryService");
            return (Criteria) this;
        }

        public Criteria andDeliveryServiceGreaterThanOrEqualTo(String value) {
            addCriterion("delivery_service >=", value, "deliveryService");
            return (Criteria) this;
        }

        public Criteria andDeliveryServiceLessThan(String value) {
            addCriterion("delivery_service <", value, "deliveryService");
            return (Criteria) this;
        }

        public Criteria andDeliveryServiceLessThanOrEqualTo(String value) {
            addCriterion("delivery_service <=", value, "deliveryService");
            return (Criteria) this;
        }

        public Criteria andDeliveryServiceLike(String value) {
            addCriterion("delivery_service like", value, "deliveryService");
            return (Criteria) this;
        }

        public Criteria andDeliveryServiceNotLike(String value) {
            addCriterion("delivery_service not like", value, "deliveryService");
            return (Criteria) this;
        }

        public Criteria andDeliveryServiceIn(List<String> values) {
            addCriterion("delivery_service in", values, "deliveryService");
            return (Criteria) this;
        }

        public Criteria andDeliveryServiceNotIn(List<String> values) {
            addCriterion("delivery_service not in", values, "deliveryService");
            return (Criteria) this;
        }

        public Criteria andDeliveryServiceBetween(String value1, String value2) {
            addCriterion("delivery_service between", value1, value2, "deliveryService");
            return (Criteria) this;
        }

        public Criteria andDeliveryServiceNotBetween(String value1, String value2) {
            addCriterion("delivery_service not between", value1, value2, "deliveryService");
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

        public Criteria andServiceTimeIsNull() {
            addCriterion("service_time is null");
            return (Criteria) this;
        }

        public Criteria andServiceTimeIsNotNull() {
            addCriterion("service_time is not null");
            return (Criteria) this;
        }

        public Criteria andServiceTimeEqualTo(Integer value) {
            addCriterion("service_time =", value, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeNotEqualTo(Integer value) {
            addCriterion("service_time <>", value, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeGreaterThan(Integer value) {
            addCriterion("service_time >", value, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_time >=", value, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeLessThan(Integer value) {
            addCriterion("service_time <", value, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeLessThanOrEqualTo(Integer value) {
            addCriterion("service_time <=", value, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeIn(List<Integer> values) {
            addCriterion("service_time in", values, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeNotIn(List<Integer> values) {
            addCriterion("service_time not in", values, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeBetween(Integer value1, Integer value2) {
            addCriterion("service_time between", value1, value2, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("service_time not between", value1, value2, "serviceTime");
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