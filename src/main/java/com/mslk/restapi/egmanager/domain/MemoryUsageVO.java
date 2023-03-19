package com.mslk.restapi.egmanager.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemoryUsageVO {

    private String trgt_host;
    private String port_no;
    private String site_name;
    private String info;
    private String msmt_host;
    private String msmt_time;
    private String total_phy_mem;
    private String total_phy_mem_st;
    private String used_phy_mem;
    private String used_phy_mem_st;
    private String free_phy_mem;
    private String free_phy_mem_st;
    private String physical_mem_utilze;
    private String physical_mem_utilze_st;
    private String physical_avail_mem;
    private String physical_avail_mem_st;
    private String modified_mem;
    private String modified_mem_st;
    private String standby_mem;
    private String standby_mem_st;
    private String cached_mem;
    private String cached_mem_st;
    private String max_mem_allocate;
    private String max_mem_allocate_st;
    private String max_mem_usage;
    private String max_mem_usage_st;
    private String automation_status;
    private String automation_status_st;

    @Builder
    public MemoryUsageVO(String trgt_host, String port_no, String site_name, String info, String msmt_host, String msmt_time, String total_phy_mem, String total_phy_mem_st, String used_phy_mem, String used_phy_mem_st, String free_phy_mem, String free_phy_mem_st, String physical_mem_utilze, String physical_mem_utilze_st, String physical_avail_mem, String physical_avail_mem_st, String modified_mem, String modified_mem_st, String standby_mem, String standby_mem_st, String cached_mem, String cached_mem_st, String max_mem_allocate, String max_mem_allocate_st, String max_mem_usage, String max_mem_usage_st, String automation_status, String automation_status_st
    ){
        this.trgt_host = trgt_host;
        this.port_no = port_no;
        this.site_name = site_name;
        this.info = info;
        this.msmt_host = msmt_host;
        this.msmt_time = msmt_time;
        this.total_phy_mem = total_phy_mem;
        this.total_phy_mem_st = total_phy_mem_st;
        this.used_phy_mem = used_phy_mem;
        this.used_phy_mem_st = used_phy_mem_st;
        this.free_phy_mem = free_phy_mem;
        this.free_phy_mem_st = free_phy_mem_st;
        this.physical_mem_utilze = physical_mem_utilze;
        this.physical_mem_utilze_st = physical_mem_utilze_st;
        this.physical_avail_mem = physical_avail_mem;
        this.physical_avail_mem_st = physical_avail_mem_st;
        this.modified_mem = modified_mem;
        this.modified_mem_st = modified_mem_st;
        this.standby_mem = standby_mem;
        this.standby_mem_st = standby_mem_st;
        this.cached_mem = cached_mem;
        this.cached_mem_st = cached_mem_st;
        this.max_mem_allocate = max_mem_allocate;
        this.max_mem_allocate_st = max_mem_allocate_st;
        this.max_mem_usage = max_mem_usage;
        this.max_mem_usage_st = max_mem_usage_st;
        this.automation_status = automation_status;
        this.automation_status_st = automation_status_st;
    }

    public MemoryUsageVO() {

    }


}
