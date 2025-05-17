package gen;
// Generated from C:/Users/ionvo/OneDrive/Desktop/GravITy/DSL_I/src/main/antlr4/GravITy.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GravITyParser}.
 */
public interface GravITyListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GravITyParser#simulation}.
	 * @param ctx the parse tree
	 */
	void enterSimulation(GravITyParser.SimulationContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#simulation}.
	 * @param ctx the parse tree
	 */
	void exitSimulation(GravITyParser.SimulationContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#simulation_body}.
	 * @param ctx the parse tree
	 */
	void enterSimulation_body(GravITyParser.Simulation_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#simulation_body}.
	 * @param ctx the parse tree
	 */
	void exitSimulation_body(GravITyParser.Simulation_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#physics_module}.
	 * @param ctx the parse tree
	 */
	void enterPhysics_module(GravITyParser.Physics_moduleContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#physics_module}.
	 * @param ctx the parse tree
	 */
	void exitPhysics_module(GravITyParser.Physics_moduleContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#collision}.
	 * @param ctx the parse tree
	 */
	void enterCollision(GravITyParser.CollisionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#collision}.
	 * @param ctx the parse tree
	 */
	void exitCollision(GravITyParser.CollisionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#movers_list}.
	 * @param ctx the parse tree
	 */
	void enterMovers_list(GravITyParser.Movers_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#movers_list}.
	 * @param ctx the parse tree
	 */
	void exitMovers_list(GravITyParser.Movers_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#mover}.
	 * @param ctx the parse tree
	 */
	void enterMover(GravITyParser.MoverContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#mover}.
	 * @param ctx the parse tree
	 */
	void exitMover(GravITyParser.MoverContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#mover_properties}.
	 * @param ctx the parse tree
	 */
	void enterMover_properties(GravITyParser.Mover_propertiesContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#mover_properties}.
	 * @param ctx the parse tree
	 */
	void exitMover_properties(GravITyParser.Mover_propertiesContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#electrostatic_field}.
	 * @param ctx the parse tree
	 */
	void enterElectrostatic_field(GravITyParser.Electrostatic_fieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#electrostatic_field}.
	 * @param ctx the parse tree
	 */
	void exitElectrostatic_field(GravITyParser.Electrostatic_fieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#particle_radius_expr}.
	 * @param ctx the parse tree
	 */
	void enterParticle_radius_expr(GravITyParser.Particle_radius_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#particle_radius_expr}.
	 * @param ctx the parse tree
	 */
	void exitParticle_radius_expr(GravITyParser.Particle_radius_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#flux_resolution_expr}.
	 * @param ctx the parse tree
	 */
	void enterFlux_resolution_expr(GravITyParser.Flux_resolution_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#flux_resolution_expr}.
	 * @param ctx the parse tree
	 */
	void exitFlux_resolution_expr(GravITyParser.Flux_resolution_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#drag_force}.
	 * @param ctx the parse tree
	 */
	void enterDrag_force(GravITyParser.Drag_forceContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#drag_force}.
	 * @param ctx the parse tree
	 */
	void exitDrag_force(GravITyParser.Drag_forceContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#mover_color_expr}.
	 * @param ctx the parse tree
	 */
	void enterMover_color_expr(GravITyParser.Mover_color_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#mover_color_expr}.
	 * @param ctx the parse tree
	 */
	void exitMover_color_expr(GravITyParser.Mover_color_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#drag_coefficient_expr}.
	 * @param ctx the parse tree
	 */
	void enterDrag_coefficient_expr(GravITyParser.Drag_coefficient_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#drag_coefficient_expr}.
	 * @param ctx the parse tree
	 */
	void exitDrag_coefficient_expr(GravITyParser.Drag_coefficient_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#liquid_color_expr}.
	 * @param ctx the parse tree
	 */
	void enterLiquid_color_expr(GravITyParser.Liquid_color_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#liquid_color_expr}.
	 * @param ctx the parse tree
	 */
	void exitLiquid_color_expr(GravITyParser.Liquid_color_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#attraction_force}.
	 * @param ctx the parse tree
	 */
	void enterAttraction_force(GravITyParser.Attraction_forceContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#attraction_force}.
	 * @param ctx the parse tree
	 */
	void exitAttraction_force(GravITyParser.Attraction_forceContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#mover1_expr}.
	 * @param ctx the parse tree
	 */
	void enterMover1_expr(GravITyParser.Mover1_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#mover1_expr}.
	 * @param ctx the parse tree
	 */
	void exitMover1_expr(GravITyParser.Mover1_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#mover2_expr}.
	 * @param ctx the parse tree
	 */
	void enterMover2_expr(GravITyParser.Mover2_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#mover2_expr}.
	 * @param ctx the parse tree
	 */
	void exitMover2_expr(GravITyParser.Mover2_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#wave}.
	 * @param ctx the parse tree
	 */
	void enterWave(GravITyParser.WaveContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#wave}.
	 * @param ctx the parse tree
	 */
	void exitWave(GravITyParser.WaveContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#start_angle_expr}.
	 * @param ctx the parse tree
	 */
	void enterStart_angle_expr(GravITyParser.Start_angle_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#start_angle_expr}.
	 * @param ctx the parse tree
	 */
	void exitStart_angle_expr(GravITyParser.Start_angle_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#angle_velocity_expr}.
	 * @param ctx the parse tree
	 */
	void enterAngle_velocity_expr(GravITyParser.Angle_velocity_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#angle_velocity_expr}.
	 * @param ctx the parse tree
	 */
	void exitAngle_velocity_expr(GravITyParser.Angle_velocity_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#amplitude_expr}.
	 * @param ctx the parse tree
	 */
	void enterAmplitude_expr(GravITyParser.Amplitude_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#amplitude_expr}.
	 * @param ctx the parse tree
	 */
	void exitAmplitude_expr(GravITyParser.Amplitude_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#frequency_expr}.
	 * @param ctx the parse tree
	 */
	void enterFrequency_expr(GravITyParser.Frequency_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#frequency_expr}.
	 * @param ctx the parse tree
	 */
	void exitFrequency_expr(GravITyParser.Frequency_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#phase_shift_expr}.
	 * @param ctx the parse tree
	 */
	void enterPhase_shift_expr(GravITyParser.Phase_shift_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#phase_shift_expr}.
	 * @param ctx the parse tree
	 */
	void exitPhase_shift_expr(GravITyParser.Phase_shift_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#uniform_motion}.
	 * @param ctx the parse tree
	 */
	void enterUniform_motion(GravITyParser.Uniform_motionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#uniform_motion}.
	 * @param ctx the parse tree
	 */
	void exitUniform_motion(GravITyParser.Uniform_motionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#mover_expr}.
	 * @param ctx the parse tree
	 */
	void enterMover_expr(GravITyParser.Mover_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#mover_expr}.
	 * @param ctx the parse tree
	 */
	void exitMover_expr(GravITyParser.Mover_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#initial_speed_expr}.
	 * @param ctx the parse tree
	 */
	void enterInitial_speed_expr(GravITyParser.Initial_speed_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#initial_speed_expr}.
	 * @param ctx the parse tree
	 */
	void exitInitial_speed_expr(GravITyParser.Initial_speed_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#accelerated_motion}.
	 * @param ctx the parse tree
	 */
	void enterAccelerated_motion(GravITyParser.Accelerated_motionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#accelerated_motion}.
	 * @param ctx the parse tree
	 */
	void exitAccelerated_motion(GravITyParser.Accelerated_motionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#initial_acceleration_expr}.
	 * @param ctx the parse tree
	 */
	void enterInitial_acceleration_expr(GravITyParser.Initial_acceleration_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#initial_acceleration_expr}.
	 * @param ctx the parse tree
	 */
	void exitInitial_acceleration_expr(GravITyParser.Initial_acceleration_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#circular_motion}.
	 * @param ctx the parse tree
	 */
	void enterCircular_motion(GravITyParser.Circular_motionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#circular_motion}.
	 * @param ctx the parse tree
	 */
	void exitCircular_motion(GravITyParser.Circular_motionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#radius_expr}.
	 * @param ctx the parse tree
	 */
	void enterRadius_expr(GravITyParser.Radius_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#radius_expr}.
	 * @param ctx the parse tree
	 */
	void exitRadius_expr(GravITyParser.Radius_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#angular_speed_expr}.
	 * @param ctx the parse tree
	 */
	void enterAngular_speed_expr(GravITyParser.Angular_speed_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#angular_speed_expr}.
	 * @param ctx the parse tree
	 */
	void exitAngular_speed_expr(GravITyParser.Angular_speed_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#ball_expr}.
	 * @param ctx the parse tree
	 */
	void enterBall_expr(GravITyParser.Ball_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#ball_expr}.
	 * @param ctx the parse tree
	 */
	void exitBall_expr(GravITyParser.Ball_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#gravity}.
	 * @param ctx the parse tree
	 */
	void enterGravity(GravITyParser.GravityContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#gravity}.
	 * @param ctx the parse tree
	 */
	void exitGravity(GravITyParser.GravityContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#earth_expr}.
	 * @param ctx the parse tree
	 */
	void enterEarth_expr(GravITyParser.Earth_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#earth_expr}.
	 * @param ctx the parse tree
	 */
	void exitEarth_expr(GravITyParser.Earth_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#moon_expr}.
	 * @param ctx the parse tree
	 */
	void enterMoon_expr(GravITyParser.Moon_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#moon_expr}.
	 * @param ctx the parse tree
	 */
	void exitMoon_expr(GravITyParser.Moon_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#spring}.
	 * @param ctx the parse tree
	 */
	void enterSpring(GravITyParser.SpringContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#spring}.
	 * @param ctx the parse tree
	 */
	void exitSpring(GravITyParser.SpringContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#spring_constant_expr}.
	 * @param ctx the parse tree
	 */
	void enterSpring_constant_expr(GravITyParser.Spring_constant_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#spring_constant_expr}.
	 * @param ctx the parse tree
	 */
	void exitSpring_constant_expr(GravITyParser.Spring_constant_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#damping_expr}.
	 * @param ctx the parse tree
	 */
	void enterDamping_expr(GravITyParser.Damping_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#damping_expr}.
	 * @param ctx the parse tree
	 */
	void exitDamping_expr(GravITyParser.Damping_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#spring_rest_length_expr}.
	 * @param ctx the parse tree
	 */
	void enterSpring_rest_length_expr(GravITyParser.Spring_rest_length_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#spring_rest_length_expr}.
	 * @param ctx the parse tree
	 */
	void exitSpring_rest_length_expr(GravITyParser.Spring_rest_length_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#floor_friction_expr}.
	 * @param ctx the parse tree
	 */
	void enterFloor_friction_expr(GravITyParser.Floor_friction_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#floor_friction_expr}.
	 * @param ctx the parse tree
	 */
	void exitFloor_friction_expr(GravITyParser.Floor_friction_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#spring_expr}.
	 * @param ctx the parse tree
	 */
	void enterSpring_expr(GravITyParser.Spring_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#spring_expr}.
	 * @param ctx the parse tree
	 */
	void exitSpring_expr(GravITyParser.Spring_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#x_anchor_position_expr}.
	 * @param ctx the parse tree
	 */
	void enterX_anchor_position_expr(GravITyParser.X_anchor_position_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#x_anchor_position_expr}.
	 * @param ctx the parse tree
	 */
	void exitX_anchor_position_expr(GravITyParser.X_anchor_position_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#y_anchor_position_expr}.
	 * @param ctx the parse tree
	 */
	void enterY_anchor_position_expr(GravITyParser.Y_anchor_position_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#y_anchor_position_expr}.
	 * @param ctx the parse tree
	 */
	void exitY_anchor_position_expr(GravITyParser.Y_anchor_position_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#num_coils_expr}.
	 * @param ctx the parse tree
	 */
	void enterNum_coils_expr(GravITyParser.Num_coils_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#num_coils_expr}.
	 * @param ctx the parse tree
	 */
	void exitNum_coils_expr(GravITyParser.Num_coils_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#pendulum}.
	 * @param ctx the parse tree
	 */
	void enterPendulum(GravITyParser.PendulumContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#pendulum}.
	 * @param ctx the parse tree
	 */
	void exitPendulum(GravITyParser.PendulumContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#length_expr}.
	 * @param ctx the parse tree
	 */
	void enterLength_expr(GravITyParser.Length_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#length_expr}.
	 * @param ctx the parse tree
	 */
	void exitLength_expr(GravITyParser.Length_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#ball_radius_expr}.
	 * @param ctx the parse tree
	 */
	void enterBall_radius_expr(GravITyParser.Ball_radius_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#ball_radius_expr}.
	 * @param ctx the parse tree
	 */
	void exitBall_radius_expr(GravITyParser.Ball_radius_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#initial_angle_expr}.
	 * @param ctx the parse tree
	 */
	void enterInitial_angle_expr(GravITyParser.Initial_angle_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#initial_angle_expr}.
	 * @param ctx the parse tree
	 */
	void exitInitial_angle_expr(GravITyParser.Initial_angle_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#angular_velocity_expr}.
	 * @param ctx the parse tree
	 */
	void enterAngular_velocity_expr(GravITyParser.Angular_velocity_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#angular_velocity_expr}.
	 * @param ctx the parse tree
	 */
	void exitAngular_velocity_expr(GravITyParser.Angular_velocity_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#angular_acceleration_expr}.
	 * @param ctx the parse tree
	 */
	void enterAngular_acceleration_expr(GravITyParser.Angular_acceleration_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#angular_acceleration_expr}.
	 * @param ctx the parse tree
	 */
	void exitAngular_acceleration_expr(GravITyParser.Angular_acceleration_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#air_resistance_expr}.
	 * @param ctx the parse tree
	 */
	void enterAir_resistance_expr(GravITyParser.Air_resistance_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#air_resistance_expr}.
	 * @param ctx the parse tree
	 */
	void exitAir_resistance_expr(GravITyParser.Air_resistance_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#rolling_uphill}.
	 * @param ctx the parse tree
	 */
	void enterRolling_uphill(GravITyParser.Rolling_uphillContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#rolling_uphill}.
	 * @param ctx the parse tree
	 */
	void exitRolling_uphill(GravITyParser.Rolling_uphillContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#gravitational_acceleration_expr}.
	 * @param ctx the parse tree
	 */
	void enterGravitational_acceleration_expr(GravITyParser.Gravitational_acceleration_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#gravitational_acceleration_expr}.
	 * @param ctx the parse tree
	 */
	void exitGravitational_acceleration_expr(GravITyParser.Gravitational_acceleration_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#coefficient_of_friction_expr}.
	 * @param ctx the parse tree
	 */
	void enterCoefficient_of_friction_expr(GravITyParser.Coefficient_of_friction_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#coefficient_of_friction_expr}.
	 * @param ctx the parse tree
	 */
	void exitCoefficient_of_friction_expr(GravITyParser.Coefficient_of_friction_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#bounciness_expr}.
	 * @param ctx the parse tree
	 */
	void enterBounciness_expr(GravITyParser.Bounciness_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#bounciness_expr}.
	 * @param ctx the parse tree
	 */
	void exitBounciness_expr(GravITyParser.Bounciness_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#angle_expr}.
	 * @param ctx the parse tree
	 */
	void enterAngle_expr(GravITyParser.Angle_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#angle_expr}.
	 * @param ctx the parse tree
	 */
	void exitAngle_expr(GravITyParser.Angle_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#velocity_along_incline_expr}.
	 * @param ctx the parse tree
	 */
	void enterVelocity_along_incline_expr(GravITyParser.Velocity_along_incline_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#velocity_along_incline_expr}.
	 * @param ctx the parse tree
	 */
	void exitVelocity_along_incline_expr(GravITyParser.Velocity_along_incline_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#mover_basic_properties}.
	 * @param ctx the parse tree
	 */
	void enterMover_basic_properties(GravITyParser.Mover_basic_propertiesContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#mover_basic_properties}.
	 * @param ctx the parse tree
	 */
	void exitMover_basic_properties(GravITyParser.Mover_basic_propertiesContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#mass_expr}.
	 * @param ctx the parse tree
	 */
	void enterMass_expr(GravITyParser.Mass_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#mass_expr}.
	 * @param ctx the parse tree
	 */
	void exitMass_expr(GravITyParser.Mass_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#velocity_expr}.
	 * @param ctx the parse tree
	 */
	void enterVelocity_expr(GravITyParser.Velocity_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#velocity_expr}.
	 * @param ctx the parse tree
	 */
	void exitVelocity_expr(GravITyParser.Velocity_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#x_velocity_expr}.
	 * @param ctx the parse tree
	 */
	void enterX_velocity_expr(GravITyParser.X_velocity_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#x_velocity_expr}.
	 * @param ctx the parse tree
	 */
	void exitX_velocity_expr(GravITyParser.X_velocity_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#y_velocity_expr}.
	 * @param ctx the parse tree
	 */
	void enterY_velocity_expr(GravITyParser.Y_velocity_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#y_velocity_expr}.
	 * @param ctx the parse tree
	 */
	void exitY_velocity_expr(GravITyParser.Y_velocity_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#position_expr}.
	 * @param ctx the parse tree
	 */
	void enterPosition_expr(GravITyParser.Position_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#position_expr}.
	 * @param ctx the parse tree
	 */
	void exitPosition_expr(GravITyParser.Position_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#x_position_expr}.
	 * @param ctx the parse tree
	 */
	void enterX_position_expr(GravITyParser.X_position_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#x_position_expr}.
	 * @param ctx the parse tree
	 */
	void exitX_position_expr(GravITyParser.X_position_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#y_position_expr}.
	 * @param ctx the parse tree
	 */
	void enterY_position_expr(GravITyParser.Y_position_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#y_position_expr}.
	 * @param ctx the parse tree
	 */
	void exitY_position_expr(GravITyParser.Y_position_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#color_expr}.
	 * @param ctx the parse tree
	 */
	void enterColor_expr(GravITyParser.Color_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#color_expr}.
	 * @param ctx the parse tree
	 */
	void exitColor_expr(GravITyParser.Color_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#red_value_expr}.
	 * @param ctx the parse tree
	 */
	void enterRed_value_expr(GravITyParser.Red_value_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#red_value_expr}.
	 * @param ctx the parse tree
	 */
	void exitRed_value_expr(GravITyParser.Red_value_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#green_value_expr}.
	 * @param ctx the parse tree
	 */
	void enterGreen_value_expr(GravITyParser.Green_value_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#green_value_expr}.
	 * @param ctx the parse tree
	 */
	void exitGreen_value_expr(GravITyParser.Green_value_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#blue_value_expr}.
	 * @param ctx the parse tree
	 */
	void enterBlue_value_expr(GravITyParser.Blue_value_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#blue_value_expr}.
	 * @param ctx the parse tree
	 */
	void exitBlue_value_expr(GravITyParser.Blue_value_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#value_expr}.
	 * @param ctx the parse tree
	 */
	void enterValue_expr(GravITyParser.Value_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#value_expr}.
	 * @param ctx the parse tree
	 */
	void exitValue_expr(GravITyParser.Value_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#simple_value}.
	 * @param ctx the parse tree
	 */
	void enterSimple_value(GravITyParser.Simple_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#simple_value}.
	 * @param ctx the parse tree
	 */
	void exitSimple_value(GravITyParser.Simple_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#conditional_value}.
	 * @param ctx the parse tree
	 */
	void enterConditional_value(GravITyParser.Conditional_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#conditional_value}.
	 * @param ctx the parse tree
	 */
	void exitConditional_value(GravITyParser.Conditional_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#loop_value}.
	 * @param ctx the parse tree
	 */
	void enterLoop_value(GravITyParser.Loop_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#loop_value}.
	 * @param ctx the parse tree
	 */
	void exitLoop_value(GravITyParser.Loop_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#initial_value}.
	 * @param ctx the parse tree
	 */
	void enterInitial_value(GravITyParser.Initial_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#initial_value}.
	 * @param ctx the parse tree
	 */
	void exitInitial_value(GravITyParser.Initial_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#multiplier}.
	 * @param ctx the parse tree
	 */
	void enterMultiplier(GravITyParser.MultiplierContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#multiplier}.
	 * @param ctx the parse tree
	 */
	void exitMultiplier(GravITyParser.MultiplierContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(GravITyParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(GravITyParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#comparator}.
	 * @param ctx the parse tree
	 */
	void enterComparator(GravITyParser.ComparatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#comparator}.
	 * @param ctx the parse tree
	 */
	void exitComparator(GravITyParser.ComparatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link GravITyParser#reference}.
	 * @param ctx the parse tree
	 */
	void enterReference(GravITyParser.ReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link GravITyParser#reference}.
	 * @param ctx the parse tree
	 */
	void exitReference(GravITyParser.ReferenceContext ctx);
}