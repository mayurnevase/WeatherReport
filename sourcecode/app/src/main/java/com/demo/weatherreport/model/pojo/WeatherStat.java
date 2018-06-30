package com.demo.weatherreport.model.pojo;

public class WeatherStat {

    private String region;

    private String sunshine_url;

    private String min_temp_type;

    private String rainfall_url;

    private String max_temp_url;

    private String rainfall_type;

    private String mean_temp;

    private String min_temp_url;

    private String mean_temp_url;

    private String max_temp_type;

    private String sunshine_type;

    public String getRegion ()
    {
        return region;
    }

    public void setRegion (String region)
    {
        this.region = region;
    }

    public String getSunshine_url ()
    {
        return sunshine_url;
    }

    public void setSunshine_url (String sunshine_url)
    {
        this.sunshine_url = sunshine_url;
    }

    public String getMin_temp_type ()
    {
        return min_temp_type;
    }

    public void setMin_temp_type (String min_temp_type)
    {
        this.min_temp_type = min_temp_type;
    }

    public String getRainfall_url ()
    {
        return rainfall_url;
    }

    public void setRainfall_url (String rainfall_url)
    {
        this.rainfall_url = rainfall_url;
    }

    public String getMax_temp_url ()
    {
        return max_temp_url;
    }

    public void setMax_temp_url (String max_temp_url)
    {
        this.max_temp_url = max_temp_url;
    }

    public String getRainfall_type ()
    {
        return rainfall_type;
    }

    public void setRainfall_type (String rainfall_type)
    {
        this.rainfall_type = rainfall_type;
    }

    public String getMean_temp ()
    {
        return mean_temp;
    }

    public void setMean_temp (String mean_temp)
    {
        this.mean_temp = mean_temp;
    }

    public String getMin_temp_url ()
    {
        return min_temp_url;
    }

    public void setMin_temp_url (String min_temp_url)
    {
        this.min_temp_url = min_temp_url;
    }

    public String getMean_temp_url ()
    {
        return mean_temp_url;
    }

    public void setMean_temp_url (String mean_temp_url)
    {
        this.mean_temp_url = mean_temp_url;
    }

    public String getMax_temp_type ()
    {
        return max_temp_type;
    }

    public void setMax_temp_type (String max_temp_type)
    {
        this.max_temp_type = max_temp_type;
    }

    public String getSunshine_type ()
    {
        return sunshine_type;
    }

    public void setSunshine_type (String sunshine_type)
    {
        this.sunshine_type = sunshine_type;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [region = "+region+", sunshine_url = "+sunshine_url+", min_temp_type = "+min_temp_type+", rainfall_url = "+rainfall_url+", max_temp_url = "+max_temp_url+", rainfall_type = "+rainfall_type+", mean_temp = "+mean_temp+", min_temp_url = "+min_temp_url+", mean_temp_url = "+mean_temp_url+", max_temp_type = "+max_temp_type+", sunshine_type = "+sunshine_type+"]";
    }
}
