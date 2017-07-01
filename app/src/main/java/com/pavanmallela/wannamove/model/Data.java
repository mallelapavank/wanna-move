package com.pavanmallela.wannamove.model;

import com.pavanmallela.wannamove.HouseListingActivity;

public class Data {

    private HouseListingActivity houseListing;
    private PackersList packersList;
    private SettlingIn settlingIn;

    public HouseListingActivity getHouseListing() {
        return houseListing;
    }

    public void setHouseListing(HouseListingActivity houseListing) {
        this.houseListing = houseListing;
    }

    public PackersList getPackersList() {
        return packersList;
    }

    public void setPackersList(PackersList packersList) {
        this.packersList = packersList;
    }

    public SettlingIn getSettlingIn() {
        return settlingIn;
    }

    public void setSettlingIn(SettlingIn settlingIn) {
        this.settlingIn = settlingIn;
    }

}
