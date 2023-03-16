package com.mslk.restapi.egmanager.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiskSpaceVO {

    private String trgt_host ;
    private String port_no;
    private String site_name;
    private String info;
    private String msmt_host;
    private String msmt_time;
    private String total_capacity;
    private String total_capacity_st;
    private String used_space;
    private String used_space_st;
    private String free_space;
    private String  free_space_st;
    private String  percent_usage;
    private String  percent_usage_st;
    private String  drive_avail;
    private String  drive_avail_st;
    private String  automation_status;
    private String  automation_status_st;

    @Builder
    public DiskSpaceVO(String trgt_host , String port_no, String site_name,String info, String msmt_host, String msmt_time, String total_capacity, String total_capacity_st, String used_space, String used_space_st, String free_space, String  free_space_st, String  percent_usage, String  percent_usage_st, String  drive_avail, String  drive_avail_st, String  automation_status, String  automation_status_st){
        this.trgt_host = trgt_host;
        this.port_no = port_no;
        this.site_name = site_name;
        this.info = info;
        this.msmt_host = msmt_host;
        this.msmt_time = msmt_time;
        this.total_capacity = total_capacity;
        this.total_capacity_st = total_capacity_st;
        this.used_space =used_space;
        this.used_space_st = used_space_st;
        this.free_space = free_space;
        this.free_space_st = free_space_st;
        this.percent_usage = percent_usage;
        this.percent_usage_st = percent_usage_st;
        this.drive_avail = drive_avail;
        this.drive_avail_st = drive_avail_st;
        this.automation_status = automation_status;
        this.automation_status_st = automation_status_st;
    }

    public DiskSpaceVO() {

    }
}
