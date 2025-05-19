public class Seat {
    private String seatId;
    private int row;
    private int column;
    private boolean isBooked;
    private double priceMultiplier;

    public Seat(String seatId, int row, int column, boolean isBooked, double priceMultiplier) {
        this.seatId = seatId;
        this.row = row;
        this.column = column;
        this.isBooked = isBooked;
        this.priceMultiplier = priceMultiplier;
    }

    public void bookSeat() {
        this.isBooked = true;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public String getSeatId() {
        return seatId;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public double getPriceMultiplier() {
        return priceMultiplier;
    }

    public String getSeatNumber() {
        return "Row " + row + ", Seat " + column;
    }

    public void setBooked(boolean booked) {
        this.isBooked = booked;
    }
}

