package org.usacoProbs;

public class Ladders {
    public static class Cell{
        public boolean northWall;
        public boolean eastWall;
        public boolean southWall;
        public boolean westWall;
        public boolean visited;

        public Cell getSouth() {
            return south;
        }

        public void setSouth(Cell south) {
            this.south = south;
            this.south.north = this;
        }

        public Cell getNorth() {
            return north;
        }

        public void setNorth(Cell north) {
            this.north = north;
            this.north.south = this;
        }

        public Cell getEast() {
            return east;
        }

        public void setEast(Cell east) {
            this.east = east;
            this.east.west = this;
        }

        public Cell getWest() {
            return west;
        }

        public void setWest(Cell west) {
            this.west = west;
            this.west.east = this;
        }

        public Cell south;
        public Cell north;
        public Cell east;
        public Cell west;

        public Cell(){
            northWall = false;
            eastWall = false;
            southWall = false;
            westWall = false;
            visited = false;
        }

        @Override
        public String toString() {
            String s = "";
            s += northWall ? "-" : " ";
            s += "*\n";
            s += northWall ? "X" : " ";
            s += northWall ? "|" : " ";

            return s;
        }

        public boolean hasNorthCell(){
            return north != null;
        }

        public boolean hasSouthCell(){
            return south != null;
        }

        public boolean hasEastCell(){
            return east != null;
        }

        public boolean hasWestCell(){
            return west != null;
        }

    }

    public static Cell makeGrid(int width, int height){
        Cell start = new Cell();
        Cell currCellX = start;
        Cell currCellY = start;

        for(int j =0; j < height-1; j++){
            currCellY.setNorth(new Cell());
            currCellY = currCellY.north;
        }

        for(int i =0; i < width-1; i++){
            currCellX.setEast(new Cell());
            currCellX = currCellX.east;
            currCellY = currCellX;
            for(int j =0; j < height-1; j++){
                currCellY.setNorth(new Cell());
                currCellY = currCellY.north;
            }
        }

        return start;
    }

    public static void main(String[] args){
        Cell n = makeGrid(10, 20);
        System.out.println("hello");
    }
}
