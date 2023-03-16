package com.mslk.restapi.egmanager.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NetworkVO {

    private String trgt_host ;
    private String port_no;
    private String site_name;
    private String info;
    private String msmt_host;
    private String msmt_time;
    private String inp_pkt_rate;
    private String inp_pkt_rate_st;
    private String out_pkt_rate;
    private String out_pkt_rate_st;

    @Builder
    public NetworkVO(String trgt_host , String port_no, String site_name,String info, String msmt_host, String msmt_time, String inp_pkt_rate, String inp_pkt_rate_st, String out_pkt_rate, String out_pkt_rate_st){
        this.trgt_host = trgt_host;
        this.port_no = port_no;
        this.site_name = site_name;
        this.info = info;
        this.msmt_host = msmt_host;
        this.msmt_time = msmt_time;
        this.inp_pkt_rate = inp_pkt_rate;
        this.inp_pkt_rate_st = inp_pkt_rate_st;
        this.out_pkt_rate =out_pkt_rate;
        this.out_pkt_rate_st = out_pkt_rate_st;
    }

    public NetworkVO() {

    }


}
