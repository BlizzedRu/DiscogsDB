
package ru.blizzed.discogsdb.model.release;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import ru.blizzed.discogsdb.model.*;

public class Release {

    @SerializedName("title")
    private String title;
    
    @SerializedName("id")
    private long id;
    
    @SerializedName("artists")
    private List<SimpleArtist> artists;
    
    @SerializedName("data_quality")
    private String dataQuality;
    
    @SerializedName("thumb")
    private String thumb;
    
    @SerializedName("community")
    private Community community;
    
    @SerializedName("companies")
    private List<Company> companies;
    
    @SerializedName("country")
    private String country;
    
    @SerializedName("date_added")
    private String dateAdded;
    
    @SerializedName("date_changed")
    private String dateChanged;
    
    @SerializedName("estimated_weight")
    private int estimatedWeight;
    
    @SerializedName("extraartists")
    private List<ExtraArtist> extraArtists;
    
    @SerializedName("format_quantity")
    private int formatQuantity;
    
    @SerializedName("formats")
    private List<Format> formats;
    
    @SerializedName("genres")
    private List<String> genres;
    
    @SerializedName("identifiers")
    private List<Identifier> identifiers;
    
    @SerializedName("images")
    private List<Image> images;
    
    @SerializedName("labels")
    private List<Label> labels;
    
    @SerializedName("lowest_price")
    private double lowestPrice;
    
    @SerializedName("master_id")
    private long masterId;
    
    @SerializedName("master_url")
    private String masterUrl;
    
    @SerializedName("notes")
    private String notes;
    
    @SerializedName("num_for_sale")
    private int numForSale;
    
    @SerializedName("released")
    private String released;
    
    @SerializedName("released_formatted")
    private String releasedFormatted;
    
    @SerializedName("resource_url")
    private String resourceUrl;
    
    @SerializedName("series")
    private List<Object> series;
    
    @SerializedName("status")
    private String status;
    
    @SerializedName("styles")
    private List<String> styles;
    
    @SerializedName("tracklist")
    private List<Track> tracks;
    
    @SerializedName("uri")
    private String uri;
    
    @SerializedName("videos")
    private List<Video> videos;
    
    @SerializedName("year")
    private int year;

    public String getTitle() {
        return title;
    }

    public long getId() {
        return id;
    }

    public List<SimpleArtist> getArtists() {
        return artists;
    }

    public String getDataQuality() {
        return dataQuality;
    }

    public String getThumb() {
        return thumb;
    }

    public Community getCommunity() {
        return community;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public String getCountry() {
        return country;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public String getDateChanged() {
        return dateChanged;
    }

    public int getEstimatedWeight() {
        return estimatedWeight;
    }

    public List<ExtraArtist> getExtraArtists() {
        return extraArtists;
    }

    public int getFormatQuantity() {
        return formatQuantity;
    }

    public List<Format> getFormats() {
        return formats;
    }

    public List<String> getGenres() {
        return genres;
    }

    public List<Identifier> getIdentifiers() {
        return identifiers;
    }

    public List<Image> getImages() {
        return images;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public double getLowestPrice() {
        return lowestPrice;
    }

    public long getMasterId() {
        return masterId;
    }

    public String getMasterUrl() {
        return masterUrl;
    }

    public String getNotes() {
        return notes;
    }

    public int getNumForSale() {
        return numForSale;
    }

    public String getReleased() {
        return released;
    }

    public String getReleasedFormatted() {
        return releasedFormatted;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public List<Object> getSeries() {
        return series;
    }

    public String getStatus() {
        return status;
    }

    public List<String> getStyles() {
        return styles;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public String getUri() {
        return uri;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public int getYear() {
        return year;
    }
}
