package com.techelevator.dao;

import com.techelevator.model.Site;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcSiteDao implements SiteDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcSiteDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Site> getSitesThatAllowRVs(int parkId) {
        List<Site> sites = new ArrayList<>();
        String sql =
                "SELECT " +
                    "site_id, " +
                    "campground.campground_id AS campground_id, " +
                    "site_number, " +
                    "max_occupancy, " +
                    "accessible, " +
                    "max_rv_length, " +
                    "utilities " +
                "FROM site " +
                "JOIN campground ON campground.campground_id = site.campground_id " +
                "WHERE park_id = ? AND max_rv_length > 0";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, parkId);
        while (results.next()) {
            sites.add(mapRowToSite(results));
        }
        return sites;
    }

    @Override
    public List<Site> getCurrentlyAvailableSites(int parkId) {
        return getAvailableSites(parkId, LocalDate.now(), LocalDate.now());
    }

    @Override
    public List<Site> getAvailableSites(int parkId, LocalDate fromDate, LocalDate toDate) {
        List<Site> reservations = new ArrayList<>();
        String sql =
                "SELECT site_id, " +
                        "site.campground_id AS campground_id, " +
                        "site_number, " +
                        "max_occupancy, " +
                        "accessible, " +
                        "max_rv_length, " +
                        "utilities " +
                "FROM site " +
                "JOIN campground ON campground.campground_id = site.campground_id " +
                "WHERE park_id = 1 AND site_id NOT IN (" +
                    "SELECT site.site_id " +
                    "FROM site " +
                    "JOIN campground ON campground.campground_id = site.campground_id " +
                    "JOIN reservation ON reservation.site_id = site.site_id " +
                    "WHERE park_id = ? AND ((? BETWEEN from_date AND to_date) OR (? BETWEEN from_date AND to_date))" +
                ");";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, parkId, fromDate, toDate);
        while (results.next()) {
            reservations.add(mapRowToSite(results));
        }
        return reservations;
    }

    private Site mapRowToSite(SqlRowSet results) {
        Site site = new Site();
        site.setSiteId(results.getInt("site_id"));
        site.setCampgroundId(results.getInt("campground_id"));
        site.setSiteNumber(results.getInt("site_number"));
        site.setMaxOccupancy(results.getInt("max_occupancy"));
        site.setAccessible(results.getBoolean("accessible"));
        site.setMaxRvLength(results.getInt("max_rv_length"));
        site.setUtilities(results.getBoolean("utilities"));
        return site;
    }
}
