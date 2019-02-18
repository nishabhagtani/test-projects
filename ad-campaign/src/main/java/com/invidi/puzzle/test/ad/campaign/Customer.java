package com.invidi.puzzle.test.ad.campaign;

public class Customer implements Comparable<Customer> {

	private String name;
	private Long impressionsPerCampaign;
	private Double revenuePerCampaign;
	private Integer campaignTobeGiven;
	private Long impressionsTobeGiven;
	
	public Customer(String name, Long impressionsPerCampaign, Double revenuePerCampaign) {
		super();
		this.name = name;
		this.impressionsPerCampaign = impressionsPerCampaign;
		this.revenuePerCampaign = revenuePerCampaign;
	}

	public Double getRevenuePerImpression() {
		return this.impressionsPerCampaign > 0 ? 
							this.revenuePerCampaign / this.impressionsPerCampaign : 0;    
	}
	
	public Integer getTotalRevenue() {
		return this.getRevenuePerCampaign().intValue() * this.campaignTobeGiven;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Long getImpressionsPerCampaign() {
		return impressionsPerCampaign;
	}
	
	public void setImpressionsPerCampaign(Long impressionsPerCampaign) {
		this.impressionsPerCampaign = impressionsPerCampaign;
	}
	
	public Double getRevenuePerCampaign() {
		return revenuePerCampaign;
	}
	
	public void setRevenuePerCampaign(Double revenuePerCampaign) {
		this.revenuePerCampaign = revenuePerCampaign;
	}

	/*@Override
	public String toString() {
		return "Customer [name=" + name + ", impressionsPerCampaign=" + impressionsPerCampaign + ", revenuePerCampaign="
				+ revenuePerCampaign + " , revenuePerImpression= " + this.getRevenuePerImpression() + " ]";
	}*/
	
	public Integer getCampaignTobeGiven() {
		return campaignTobeGiven;
	}

	public void setCampaignTobeGiven(Integer campaignTobeGiven) {
		this.campaignTobeGiven = campaignTobeGiven;
	}

	public Long getImpressionsTobeGiven() {
		return impressionsTobeGiven;
	}

	public void setImpressionsTobeGiven(Long impressionsTobeGiven) {
		this.impressionsTobeGiven = impressionsTobeGiven;
	}

	@Override
	public int compareTo(Customer c) {
		int i = new Double(c.getRevenuePerImpression()).compareTo(new Double(this.getRevenuePerImpression()));
		return i == 0 ? new Long(this.getImpressionsPerCampaign()).compareTo(new Long(c.getImpressionsPerCampaign())) : i; 
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", impressionsPerCampaign=" + impressionsPerCampaign + ", revenuePerCampaign="
				+ revenuePerCampaign + ", campaignTobeGiven=" + campaignTobeGiven + ", impressionsTobeGiven="
				+ impressionsTobeGiven + " , revenuePerImpression= " + this.getRevenuePerImpression() + " ]";
	}
	
}
