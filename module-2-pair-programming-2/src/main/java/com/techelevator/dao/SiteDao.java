package com.techelevator.dao;

import com.techelevator.model.Site;

import java.time.LocalDate;
import java.util.List;

public interface SiteDao {

    List<Site> getSitesThatAllowRVs(int parkId);
    List<Site> getCurrentlyAvailableSites(int parkId);
    List<Site> getAvailableSites(int parkId, LocalDate fromDate, LocalDate toDate);
}
