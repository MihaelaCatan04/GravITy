//package oop.practice;
//
//import gen.MyDSLBaseVisitor;
//import gen.MyDSLParser;
//
//public class MyDSLVisitorImpl extends MyDSLBaseVisitor<Void> {
//
//    @Override
//    public Void visitSimulation(MyDSLParser.SimulationContext ctx) {
//        System.out.println("Start Simulation...");
//        return visitChildren(ctx);
//    }
//
//    @Override
//    public Void visitCollision(MyDSLParser.CollisionContext ctx) {
//        System.out.println("Collision detected with movers:");
//        return visitChildren(ctx);
//    }
//
//    @Override
//    public Void visitMover(MyDSLParser.MoverContext ctx) {
//        System.out.println("   Mover Created!");
//        return visitChildren(ctx);
//    }
//
//    @Override
//    public Void visitRadius_expr(MyDSLParser.Radius_exprContext ctx) {
//        System.out.println("   Radius: " + ctx.value_expr().getText());
//        return null;
//    }
//
//    @Override
//    public Void visitVelocity_expr(MyDSLParser.Velocity_exprContext ctx) {
//        System.out.println("    Velocity: X=" + ctx.x_velocity_expr().value_expr().getText() +
//                ", Y=" + ctx.y_velocity_expr().value_expr().getText());
//        return null;
//    }
//
//    @Override
//    public Void visitPosition_expr(MyDSLParser.Position_exprContext ctx) {
//        System.out.println("  Position: X=" + ctx.x_position_expr().value_expr().getText() +
//                ", Y=" + ctx.y_position_expr().value_expr().getText());
//        return null;
//    }
//
//    @Override
//    public Void visitColor_expr(MyDSLParser.Color_exprContext ctx) {
//        System.out.println("  Color: R=" + ctx.red_value_expr().value_expr().getText() +
//                ", G=" + ctx.green_value_expr().value_expr().getText() +
//                ", B=" + ctx.blue_value_expr().value_expr().getText());
//        return null;
//    }
//}
