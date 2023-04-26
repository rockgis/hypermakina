package com.mslk.restapi.egmanager.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TiberoTablespacesVO {

    private String trgt_host ;
    private String port_no;
    private String site_name;
    private String info;
    private String msmt_host;
    private String msmt_time;

    private String current_usage;
    private String current_usage_st;
    private String physical_read_rate;
    private String physical_read_rate_st;
    private String physical_write_rate;
    private String physical_write_rate_st;
    private String autoextensible;
    private String autoextensible_st;
    private String max_size;
    private String max_size_st;
    private String current_size;
    private String current_size_st;
    private String free_space;
    private String free_space_st;
    private String pct_free_space;
    private String pct_free_space_st;
    private String biggest_extent;
    private String biggest_extent_st;
    private String smallest_extent;
    private String smallest_extent_st;
    private String remaining_extents;
    private String remaining_extents_st;


    @Builder
    public TiberoTablespacesVO(String trgt_host , String port_no, String site_name, String info, String msmt_host, String msmt_time, String current_usage, String current_usage_st, String physical_read_rate, String physical_read_rate_st, String physical_write_rate,
                               String  physical_write_rate_st,
                               String  autoextensible,
                               String  autoextensible_st,
                               String  max_size,
                               String  max_size_st,
                               String  current_size,
                               String  current_size_st,
                               String  free_space,
                               String  free_space_st,
                               String  pct_free_space,
                               String  pct_free_space_st,
                               String  biggest_extent,
                               String  biggest_extent_st,
                               String  smallest_extent,
                               String  smallest_extent_st,
                               String  remaining_extents,
                               String  remaining_extents_st){
        this.trgt_host = trgt_host;
        this.port_no = port_no;
        this.site_name = site_name;
        this.info = info;
        this.msmt_host = msmt_host;
        this.msmt_time = msmt_time;
        this.current_usage = current_usage;
        this.current_usage_st = current_usage_st;
        this.physical_read_rate = physical_read_rate;
        this.physical_read_rate_st = physical_read_rate_st;
        this.physical_write_rate = physical_write_rate;
        this.physical_write_rate_st = physical_write_rate_st;
        this.autoextensible = autoextensible;
        this.autoextensible_st = autoextensible_st;
        this.max_size = max_size;
        this.max_size_st = max_size_st;
        this.current_size = current_size;
        this.current_size_st = current_size_st;
        this.free_space =free_space;
        this.free_space_st = free_space_st;
        this.pct_free_space = pct_free_space;
        this.pct_free_space_st = pct_free_space_st;
        this.biggest_extent = biggest_extent;
        this.biggest_extent_st = biggest_extent_st;
        this.smallest_extent = smallest_extent;
        this.smallest_extent_st = smallest_extent_st;
        this.remaining_extents = remaining_extents;
        this.remaining_extents_st = remaining_extents_st;

    }

    public TiberoTablespacesVO() {

    }
}
