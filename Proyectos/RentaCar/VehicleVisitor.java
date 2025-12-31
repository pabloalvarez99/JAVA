/**
 * Visitor Pattern: Interface for operations on vehicles
 * Allows adding new operations without modifying vehicle classes
 */
public interface VehicleVisitor {
    void visitCamioneta(Camioneta camioneta);
    void visitSUV(SUV suv);
    void visitAuto(Auto auto);
}
