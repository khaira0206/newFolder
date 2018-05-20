import java.util.Vector;

public class A_Star
{
    private int[] mMap = null;
    private int mMapWidth = 0;
    private int mStart = 0;
    private int mGoal = 0;
    private Node mGoalNode = null;
    
    private Vector<Integer> mClosedList = null;
    private Vector<Node> mOpenList = null;
    
    public A_Star(int start, int goal, int width, int[] map)
    {
        this.setMap(map);
        this.setMapWidth(width);
        this.setStart(start);
        this.setGoal(goal);
        this.initialize();
        return;
    }
    
    private void initialize()
    {
        this.mClosedList = new Vector<Integer>();
        this.mOpenList = new Vector<Node>();
        
        for(int i = 0; i < this.mMap.length; i++)
        {
            if(this.mMap[i] == 1){
                this.mClosedList.add(i);
            }
        }
        
        // Add start node to Open List.
        double distance = getDistance(this.mStart, this.mGoal);
        this.mOpenList.add(new Node(this.mStart, null, 0.0, distance));
        
        return;
    }
    
    public Vector<Integer> search()
    {
        Vector<Integer> route = null;
        if(this.findRoute()){
            route = this.traceBack();
        }
        
        return route;
    }
    
    private boolean findRoute()
    {
        if(this.mOpenList.isEmpty()) { return false; }
        
        Node node = this.mOpenList.remove(0);
        if(node.getLocation() == this.mGoal){
            this.mGoalNode = node;
            return true;
        }
        
        // If node isn't on the ClosedList, add its children to the OpenList.
        if(this.searchClosedList(node.getLocation()) == false){
            this.mClosedList.add(node.getLocation());
            this.addChildrenToOpenList(node);
        }
        
        return findRoute();
    }
    
    private void addChildrenToOpenList(Node parent)
    {
        for(int y = -1; y < 2; y++)
        {
            for(int x = -1; x < 2; x++)
            {
                int childLocation = parent.getLocation() + (this.mMapWidth * y) + x;
                
                // If it's not in the ClosedList...
                if(this.searchClosedList(childLocation) == false){
                    // and there's no obstruction...
                    if(this.mMap[childLocation] != 1){
                        double fromStart = parent.getDistanceFromStart() + getDistance(childLocation, parent.getLocation());
                        double total = fromStart + getDistance(childLocation, this.mGoal);
                        this.addToOpenList(new Node(childLocation, parent, fromStart, total));
                    }
                }
            }
        }
        return;
    }
    
    private void addToOpenList(Node node)
    {
        if(this.mOpenList.isEmpty()){
            this.mOpenList.add(node);
        }else{
            double f = node.getTotalDistance();
            
            // Nodes are added in ascending order by total distance.
            for(int i = 0; i < this.mOpenList.size(); i++)
            {
                if(f < this.mOpenList.get(i).getTotalDistance()){
                    this.mOpenList.insertElementAt(node, i);
                    return;
                }
            }
            this.mOpenList.insertElementAt(node, this.mOpenList.size());
        }
        return;
    }
    
    private Vector<Integer> traceBack()
    {
        Vector<Integer> route = new Vector<Integer>();
        Node node = this.mGoalNode;
        while(node != null)
        {
            route.insertElementAt(node.getLocation(), 0);
            node = node.getParent();
        }
        return route;
    }
    
    // Returns true if the ClosedList contains specified number.
    private boolean searchClosedList(int thatLocation)
    {
        boolean found = false;
        for(Integer thisLocation : this.mClosedList)
        {
            if(thisLocation == thatLocation){
                found = true;
                break;
            }
        }
        return found;
    }
    
    private double getDistance(int location1, int location2)
    {
        double x1 = location1 % this.mMapWidth;
        double x2 = location2 % this.mMapWidth;
        double y1 = Math.floor(location1 / this.mMapWidth);
        double y2 = Math.floor(location2 / this.mMapWidth);
        
        double dx = Math.abs(x1 - x2);
        double dy = Math.abs(y1 - y2);
        
        return Math.sqrt(dx * dx + dy * dy);
    }
    
    private void setMap(int[] map)
    {
        try{
            if(map != null){
                this.mMap = map;
            }else{
                throw new Exception("Parameter cannot be null.");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    private void setMapWidth(int width)
    {
        try{
            if(width >= 0 && width < this.mMap.length){
                this.mMapWidth = width;
            }else{
                throw new Exception("Invalid parameter: " + width);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return;
    }
    
    private void setStart(int start)
    {
        try{
            if(start >= 0 && start < this.mMap.length){
                this.mStart = start;
            }else{
                throw new Exception("Invalid parameter: " + start);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return;
    }
    
    private void setGoal(int goal)
    {
        try{
            if(goal >= 0 && goal < this.mMap.length){
                this.mGoal = goal;
            }else{
                throw new Exception("Parameter cannot be null.");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return;
    }
    
    private class Node
    {
        private int mLocation = 0;
        private Node mParent = null;
        private double mDistanceFromStart = 0.0;
        private double mTotalDistance = 0.0;
        
        public Node(int location, Node parent, double fromStart, double distance)
        {
            this.setLocation(location);
            this.setParent(parent);
            this.setDistanceFromStart(fromStart);
            this.setTotalDistance(distance);
            return;
        }
        
        private void setLocation(int location)
        {
            try{
                if(location >= 0){
                    this.mLocation = location;
                }else{
                    throw new Exception("Invalid parameter: " + location);
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
            return;
        }
        
        public int getLocation()
        {
            return this.mLocation;
        }
        
        // parent can be null.
        private void setParent(Node parent)
        {
            this.mParent = parent;
            return;
        }
        
        public Node getParent()
        {
            return this.mParent;
        }
        
        private void setDistanceFromStart(double fromStart)
        {
            try{
                if(fromStart >= 0.0){
                    this.mDistanceFromStart = fromStart;
                }else{
                    throw new Exception("Invalid parameter given: " + fromStart);
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
            return;
        }
        
        public double getDistanceFromStart()
        {
            return this.mDistanceFromStart;
        }
        
        private void setTotalDistance(double distance)
        {
            try{
                if(distance >= 0.0){
                    this.mTotalDistance = distance;
                }else{
                    throw new Exception("Invalid parameter given: " + distance);
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
            return;
        }
        
        public double getTotalDistance()
        {
            return this.mTotalDistance;
        }
    }
    
    public static void main(String[] args)
    {
        // "1" is an obstruction, and "0" is an open space.
        int[] MAP = new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                               1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,
                               1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1,
                               1, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 1,
                               1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 0, 0, 1,
                               1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 1,
                               1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1,
                               1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1,
                               1, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1,
                               1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1,
                               1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,
                               1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,
                               1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        
        int MAP_WIDTH = 13;
        
        // Conversion from 2D coordinates (x, y) to 1D index:
        //        index = width * y + x
        
        // Conversion from 1D coordinate to 2D coordinates:
        //        x = index % width
        //        y = floored value of index / width
        
        A_Star astar1 = new A_Star(53, 73, MAP_WIDTH, MAP);
        Vector<Integer> route = astar1.search();
        if(route != null){
            for(Integer location : route)
            {
                System.out.print(location + ", ");
            }
        }else{
            System.out.println("No path found.");
        }
        return;
    }

}