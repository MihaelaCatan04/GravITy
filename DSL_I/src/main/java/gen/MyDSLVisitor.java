package gen;


// Generated from C:/Users/ionvo/OneDrive/Desktop/DSL_I/src/main/antlr4/MyDSL.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MyDSLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MyDSLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#simulation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimulation(MyDSLParser.SimulationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#simulation_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimulation_body(MyDSLParser.Simulation_bodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#physics_module}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPhysics_module(MyDSLParser.Physics_moduleContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#collision}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollision(MyDSLParser.CollisionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#movers_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMovers_list(MyDSLParser.Movers_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#mover}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMover(MyDSLParser.MoverContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#mover_properties}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMover_properties(MyDSLParser.Mover_propertiesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#electrostatic_field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElectrostatic_field(MyDSLParser.Electrostatic_fieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#particle_radius_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParticle_radius_expr(MyDSLParser.Particle_radius_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#flux_resolution_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlux_resolution_expr(MyDSLParser.Flux_resolution_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#drag_force}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrag_force(MyDSLParser.Drag_forceContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#mover_color_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMover_color_expr(MyDSLParser.Mover_color_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#drag_coefficient_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrag_coefficient_expr(MyDSLParser.Drag_coefficient_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#liquid_color_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiquid_color_expr(MyDSLParser.Liquid_color_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#attraction_force}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttraction_force(MyDSLParser.Attraction_forceContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#mover1_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMover1_expr(MyDSLParser.Mover1_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#mover2_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMover2_expr(MyDSLParser.Mover2_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#wave}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWave(MyDSLParser.WaveContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#start_angle_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart_angle_expr(MyDSLParser.Start_angle_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#angle_velocity_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAngle_velocity_expr(MyDSLParser.Angle_velocity_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#amplitude_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAmplitude_expr(MyDSLParser.Amplitude_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#frequency_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFrequency_expr(MyDSLParser.Frequency_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#phase_shift_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPhase_shift_expr(MyDSLParser.Phase_shift_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#uniform_motion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUniform_motion(MyDSLParser.Uniform_motionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#mover_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMover_expr(MyDSLParser.Mover_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#initial_speed_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitial_speed_expr(MyDSLParser.Initial_speed_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#accelerated_motion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccelerated_motion(MyDSLParser.Accelerated_motionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#initial_acceleration_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitial_acceleration_expr(MyDSLParser.Initial_acceleration_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#circular_motion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCircular_motion(MyDSLParser.Circular_motionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#radius_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRadius_expr(MyDSLParser.Radius_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#angular_speed_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAngular_speed_expr(MyDSLParser.Angular_speed_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#ball_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBall_expr(MyDSLParser.Ball_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#gravity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGravity(MyDSLParser.GravityContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#earth_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEarth_expr(MyDSLParser.Earth_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#moon_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoon_expr(MyDSLParser.Moon_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#spring}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpring(MyDSLParser.SpringContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#spring_constant_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpring_constant_expr(MyDSLParser.Spring_constant_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#damping_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDamping_expr(MyDSLParser.Damping_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#spring_rest_length_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpring_rest_length_expr(MyDSLParser.Spring_rest_length_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#floor_friction_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloor_friction_expr(MyDSLParser.Floor_friction_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#spring_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpring_expr(MyDSLParser.Spring_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#x_anchor_position_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitX_anchor_position_expr(MyDSLParser.X_anchor_position_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#y_anchor_position_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitY_anchor_position_expr(MyDSLParser.Y_anchor_position_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#num_coils_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNum_coils_expr(MyDSLParser.Num_coils_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#pendulum}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPendulum(MyDSLParser.PendulumContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#length_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLength_expr(MyDSLParser.Length_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#ball_radius_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBall_radius_expr(MyDSLParser.Ball_radius_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#initial_angle_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitial_angle_expr(MyDSLParser.Initial_angle_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#angular_velocity_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAngular_velocity_expr(MyDSLParser.Angular_velocity_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#angular_acceleration_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAngular_acceleration_expr(MyDSLParser.Angular_acceleration_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#air_resistance_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAir_resistance_expr(MyDSLParser.Air_resistance_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#rolling_uphill}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRolling_uphill(MyDSLParser.Rolling_uphillContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#gravitational_acceleration_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGravitational_acceleration_expr(MyDSLParser.Gravitational_acceleration_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#coefficient_of_friction_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCoefficient_of_friction_expr(MyDSLParser.Coefficient_of_friction_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#bounciness_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBounciness_expr(MyDSLParser.Bounciness_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#angle_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAngle_expr(MyDSLParser.Angle_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#velocity_along_incline_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVelocity_along_incline_expr(MyDSLParser.Velocity_along_incline_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#mover_basic_properties}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMover_basic_properties(MyDSLParser.Mover_basic_propertiesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#mass_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMass_expr(MyDSLParser.Mass_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#velocity_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVelocity_expr(MyDSLParser.Velocity_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#x_velocity_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitX_velocity_expr(MyDSLParser.X_velocity_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#y_velocity_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitY_velocity_expr(MyDSLParser.Y_velocity_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#position_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPosition_expr(MyDSLParser.Position_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#x_position_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitX_position_expr(MyDSLParser.X_position_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#y_position_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitY_position_expr(MyDSLParser.Y_position_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#color_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColor_expr(MyDSLParser.Color_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#red_value_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRed_value_expr(MyDSLParser.Red_value_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#green_value_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreen_value_expr(MyDSLParser.Green_value_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#blue_value_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlue_value_expr(MyDSLParser.Blue_value_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#value_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue_expr(MyDSLParser.Value_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#simple_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_value(MyDSLParser.Simple_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#conditional_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditional_value(MyDSLParser.Conditional_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#loop_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoop_value(MyDSLParser.Loop_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#initial_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitial_value(MyDSLParser.Initial_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#multiplier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplier(MyDSLParser.MultiplierContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(MyDSLParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#comparator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparator(MyDSLParser.ComparatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyDSLParser#reference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReference(MyDSLParser.ReferenceContext ctx);
}