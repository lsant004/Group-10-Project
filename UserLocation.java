public class UserLocation extends Location 
{
    public UserLocation(String id, String address, double latitude, double longitude)
    {
        super(id, address, latitude, longitude);
    }

    // haversine formula to calculate the distance between two points on the Earth's surface
    public double calculateDistance(StoreLocation store)
    {
        final double R = 6371; // Radius of Earth in km

        double latDistance = Math.toRadians(store.getLatitude() - this.latitude);
        double lonDistance = Math.toRadians(store.getLongitude() - this.longitude);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + Math.cos(Math.toRadians(this.latitude)) * Math.cos(Math.toRadians(store.getLatitude())) * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2); 
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return R * c; // convert to meters
    }

    @Override
    public String toString()
    {
        return "UserLocation [id=" + id + ", address=" + address + ", latitude=" latitude + ", longitude=" + longitude + "]";
    }
    
}
