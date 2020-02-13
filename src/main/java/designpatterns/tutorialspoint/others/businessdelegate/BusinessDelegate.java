package designpatterns.tutorialspoint.others.businessdelegate;

public class BusinessDelegate {
	private BusinessLookUp lookupService = new BusinessLookUp();
	private BusinessService businessService;
	private String serviceType;

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public void doTask() {
		this.businessService = this.lookupService.getBusinessService(this.serviceType);
		this.businessService.doProcessing();		
	}
}
