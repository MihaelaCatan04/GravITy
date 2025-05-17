// Generated from C:/Users/ionvo/OneDrive/Desktop/GravITy/DSL_I/src/main/antlr4/GravITy.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GravITyParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GravITyVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GravITyParser#simulation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimulation(GravITyParser.SimulationContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#simulation_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimulation_body(GravITyParser.Simulation_bodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#physics_module}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPhysics_module(GravITyParser.Physics_moduleContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#collision}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollision(GravITyParser.CollisionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#movers_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMovers_list(GravITyParser.Movers_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#mover}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMover(GravITyParser.MoverContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#mover_properties}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMover_properties(GravITyParser.Mover_propertiesContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#electrostatic_field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElectrostatic_field(GravITyParser.Electrostatic_fieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#particle_radius_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParticle_radius_expr(GravITyParser.Particle_radius_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#flux_resolution_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlux_resolution_expr(GravITyParser.Flux_resolution_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#drag_force}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrag_force(GravITyParser.Drag_forceContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#mover_color_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMover_color_expr(GravITyParser.Mover_color_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#drag_coefficient_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrag_coefficient_expr(GravITyParser.Drag_coefficient_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#liquid_color_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiquid_color_expr(GravITyParser.Liquid_color_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#attraction_force}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttraction_force(GravITyParser.Attraction_forceContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#mover1_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMover1_expr(GravITyParser.Mover1_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#mover2_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMover2_expr(GravITyParser.Mover2_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#wave}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWave(GravITyParser.WaveContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#start_angle_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart_angle_expr(GravITyParser.Start_angle_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#angle_velocity_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAngle_velocity_expr(GravITyParser.Angle_velocity_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#amplitude_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAmplitude_expr(GravITyParser.Amplitude_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#frequency_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFrequency_expr(GravITyParser.Frequency_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#phase_shift_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPhase_shift_expr(GravITyParser.Phase_shift_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#uniform_motion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUniform_motion(GravITyParser.Uniform_motionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#mover_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMover_expr(GravITyParser.Mover_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#initial_speed_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitial_speed_expr(GravITyParser.Initial_speed_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#accelerated_motion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccelerated_motion(GravITyParser.Accelerated_motionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#initial_acceleration_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitial_acceleration_expr(GravITyParser.Initial_acceleration_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#circular_motion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCircular_motion(GravITyParser.Circular_motionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#radius_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRadius_expr(GravITyParser.Radius_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#angular_speed_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAngular_speed_expr(GravITyParser.Angular_speed_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#ball_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBall_expr(GravITyParser.Ball_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#gravity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGravity(GravITyParser.GravityContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#earth_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEarth_expr(GravITyParser.Earth_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#moon_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoon_expr(GravITyParser.Moon_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#spring}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpring(GravITyParser.SpringContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#spring_constant_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpring_constant_expr(GravITyParser.Spring_constant_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#damping_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDamping_expr(GravITyParser.Damping_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#spring_rest_length_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpring_rest_length_expr(GravITyParser.Spring_rest_length_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#floor_friction_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloor_friction_expr(GravITyParser.Floor_friction_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#spring_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpring_expr(GravITyParser.Spring_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#x_anchor_position_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitX_anchor_position_expr(GravITyParser.X_anchor_position_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#y_anchor_position_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitY_anchor_position_expr(GravITyParser.Y_anchor_position_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#num_coils_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNum_coils_expr(GravITyParser.Num_coils_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#pendulum}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPendulum(GravITyParser.PendulumContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#length_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLength_expr(GravITyParser.Length_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#ball_radius_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBall_radius_expr(GravITyParser.Ball_radius_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#initial_angle_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitial_angle_expr(GravITyParser.Initial_angle_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#angular_velocity_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAngular_velocity_expr(GravITyParser.Angular_velocity_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#angular_acceleration_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAngular_acceleration_expr(GravITyParser.Angular_acceleration_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#air_resistance_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAir_resistance_expr(GravITyParser.Air_resistance_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#rolling_uphill}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRolling_uphill(GravITyParser.Rolling_uphillContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#gravitational_acceleration_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGravitational_acceleration_expr(GravITyParser.Gravitational_acceleration_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#coefficient_of_friction_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCoefficient_of_friction_expr(GravITyParser.Coefficient_of_friction_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#bounciness_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBounciness_expr(GravITyParser.Bounciness_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#angle_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAngle_expr(GravITyParser.Angle_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#velocity_along_incline_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVelocity_along_incline_expr(GravITyParser.Velocity_along_incline_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#mover_basic_properties}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMover_basic_properties(GravITyParser.Mover_basic_propertiesContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#mass_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMass_expr(GravITyParser.Mass_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#velocity_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVelocity_expr(GravITyParser.Velocity_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#x_velocity_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitX_velocity_expr(GravITyParser.X_velocity_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#y_velocity_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitY_velocity_expr(GravITyParser.Y_velocity_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#position_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPosition_expr(GravITyParser.Position_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#x_position_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitX_position_expr(GravITyParser.X_position_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#y_position_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitY_position_expr(GravITyParser.Y_position_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#color_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColor_expr(GravITyParser.Color_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#red_value_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRed_value_expr(GravITyParser.Red_value_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#green_value_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreen_value_expr(GravITyParser.Green_value_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#blue_value_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlue_value_expr(GravITyParser.Blue_value_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#value_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue_expr(GravITyParser.Value_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#simple_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_value(GravITyParser.Simple_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#conditional_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditional_value(GravITyParser.Conditional_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#loop_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoop_value(GravITyParser.Loop_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#initial_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitial_value(GravITyParser.Initial_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#multiplier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplier(GravITyParser.MultiplierContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(GravITyParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#comparator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparator(GravITyParser.ComparatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link GravITyParser#reference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReference(GravITyParser.ReferenceContext ctx);
}