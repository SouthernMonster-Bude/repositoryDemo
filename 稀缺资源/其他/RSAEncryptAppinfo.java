public class RSAEncryptAppinfo {

	public static String encryptByPublicKeySN(AppInfosDto infos){
		String appid = infos.appid + "-" +infos.version+"-"+ infos.sign + "-" + infos.info;
		System.out.println("before encryptByPublicKey>>\t"+appid);
		try{
			appid = RSAOfMicroSvc.encryptByPublicKeySN(appid);
			System.out.println("after encryptByPublicKey>>\t"+appid);
		}catch (Exception e){
			e.printStackTrace();
		}
		return appid;
	}
	public static String decryptByPublicKeySN(String appid){
		System.out.println("before decryptByPublicKey>>\t"+appid);
		try{
			appid = RSAOfMicroSvc.decryptByPrivateKeySN(appid);
			System.out.println("after decryptByPublicKey>>\t"+appid);
		}catch (Exception e){
			e.printStackTrace();
		}
		return appid;
	}

	///Test part
	static class AppInfosDto{
		String appid = "5566441";
		String version = "0.0.1";
		String sign = "AKSJ124581";
		String info = "9944ASAS";
	}
	public static void main(String[] args) throws Exception {
		AppInfosDto a = new AppInfosDto();
		String appid = encryptByPublicKeySN(a);
		decryptByPublicKeySN(appid);
	}
}
