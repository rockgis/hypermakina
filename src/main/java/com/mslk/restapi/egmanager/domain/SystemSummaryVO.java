package com.mslk.restapi.egmanager.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SystemSummaryVO {

    private String trgt_host ;
    private String port_no;
    private String site_name;
    private String info;
    private String msmt_host;
    private String msmt_time;
    private String cpu_util;
    private String cpu_util_st;
    private String sys_cpu_util;
    private String sys_cpu_util_st;
    private String running_proc;
    private String  running_proc_st;
    private String  blocked_proc;
    private String  blocked_proc_st;
    private String  swap_avail;
    private String  swap_avail_st;
    private String  free_mem_avail;
    private String  free_mem_avail_st;
    private String  mem_scan_rate;
    private String  mem_scan_rate_st;
    private String  steal_time;
    private String  steal_time_st;

    @Builder
    public SystemSummaryVO(String trgt_host , String port_no, String site_name,String info, String msmt_host, String msmt_time, String cpu_util, String cpu_util_st, String sys_cpu_util, String sys_cpu_util_st, String running_proc, String  running_proc_st, String  blocked_proc, String  blocked_proc_st, String  swap_avail, String  swap_avail_st, String  free_mem_avail, String  free_mem_avail_st, String  mem_scan_rate, String  mem_scan_rate_st, String  steal_time, String  steal_time_st){
        this.trgt_host = trgt_host;
        this.port_no = port_no;
        this.site_name = site_name;
        this.info = info;
        this.msmt_host = msmt_host;
        this.msmt_time = msmt_time;
        this.cpu_util = cpu_util;
        this.cpu_util_st = cpu_util_st;
        this.sys_cpu_util =sys_cpu_util;
        this.sys_cpu_util_st = sys_cpu_util_st;
        this.running_proc = running_proc;
        this.running_proc_st = running_proc_st;
        this.blocked_proc = blocked_proc;
        this.blocked_proc_st = blocked_proc_st;
        this.swap_avail = swap_avail;
        this.swap_avail_st = swap_avail_st;
        this.free_mem_avail = free_mem_avail;
        this.free_mem_avail_st = free_mem_avail_st;
        this.mem_scan_rate = mem_scan_rate;
        this.mem_scan_rate_st = mem_scan_rate_st;
        this.steal_time = steal_time;
        this.steal_time_st = steal_time_st;

    }

    public SystemSummaryVO() {

    }
}
