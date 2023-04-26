package com.mslk.restapi.egmanager.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TiberoGrowthVO {

    private String trgt_host ;
    private String port_no;
    private String site_name;
    private String info;
    private String msmt_host;
    private String msmt_time;


    private String total_size;
    private String total_size_st;
    private String used_space;
    private String used_space_st;
    private String free_space;
    private String free_space_st;
    private String used_percentage;
    private String used_percentage_st;
    private String free_percentage;
    private String free_percentage_st;


    @Builder
    public TiberoGrowthVO(String trgt_host , String port_no, String site_name, String info, String msmt_host, String msmt_time,
                          String total_size,
                          String total_size_st,
                          String used_space,
                          String used_space_st,
                          String  free_space,
                          String  free_space_st,
                          String  used_percentage,
                          String  used_percentage_st,
                          String  free_percentage,
                          String  free_percentage_st){
        this.trgt_host = trgt_host;
        this.port_no = port_no;
        this.site_name = site_name;
        this.info = info;
        this.msmt_host = msmt_host;
        this.msmt_time = msmt_time;
        this.total_size = total_size;
        this.total_size_st = total_size_st;
        this.used_space = used_space;
        this.used_space_st = used_space_st;
        this.free_space =free_space;
        this.free_space_st = free_space_st;
        this.used_percentage = used_percentage;
        this.used_percentage_st = used_percentage_st;
        this.free_percentage = free_percentage;
        this.free_percentage_st = free_percentage_st;

    }

    public TiberoGrowthVO() {

    }
}
