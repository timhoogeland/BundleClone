package Services;

public class ServiceProvider {
    private static UserService userService = new UserService();
    private static ContractService contractService = new ContractService();
    
    public static UserService getUserService() { return userService; }
    public static ContractService getContractService() { return contractService; }
}
