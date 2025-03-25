grammar GravITy;

// Root rule for a simulation, which starts with the keyword 'simulation' and contains a body
simulation: 'simulation' '{' simulation_body '}' ;

// Simulation body, which contains a list of physics modules
simulation_body: physics_module ;

// A physics module can be any one of the following types
physics_module: collision
              | electrostatic_field
              | drag_force
              | attraction_force
              | wave
              | uniform_motion
              | accelerated_motion
              | circular_motion
              | gravity
              | spring
              | pendulum
              | rolling_uphill ;

// A collision module consists of the keyword 'collision' and a list of movers inside curly braces
collision: 'collision' '{' movers_list '}' ;

// A list of movers, which must contain one or more mover objects
movers_list: mover+ ;

// A mover module starts with the keyword 'mover' and contains its properties inside curly braces
mover: 'mover' '{' mover_properties '}' ;

// The properties of a mover include radius, mass, velocity, position, and color
mover_properties: radius_expr mass_expr velocity_expr position_expr color_expr ;

// The electrostatic field module starts with the keyword 'electrostatic_field' and contains expressions for particle radius and flux resolution
electrostatic_field: 'electrostatic_field' '{' particle_radius_expr flux_resolution_expr '}' ;

// The particle radius expression defines the radius of particles in the field
particle_radius_expr: 'particle_radius' ':' value_expr ;

// The flux resolution expression defines the resolution for the flux in the field
flux_resolution_expr: 'flux_resolution' ':' value_expr ;

// The drag force module contains expressions for mover color, drag coefficient, and liquid color
drag_force: 'drag_force' '{' mover_color_expr drag_coefficient_expr liquid_color_expr '}' ;

// The mover color expression defines the color of the mover in RGB
mover_color_expr: 'mover_color' '{' red_value_expr green_value_expr blue_value_expr '}' ;

// The drag coefficient expression defines the coefficient of drag for the mover
drag_coefficient_expr: 'drag_coefficient' ':' value_expr ;

// The liquid color expression defines the color of the liquid in RGB
liquid_color_expr: 'liquid_color' '{' red_value_expr green_value_expr blue_value_expr '}' ;

// The attraction force module defines two movers involved in the attraction
attraction_force: 'attraction_force' '{' mover1_expr mover2_expr '}' ;

// The first mover involved in the attraction force
mover1_expr: 'mover1' '{' mover_properties '}' ;

// The second mover involved in the attraction force
mover2_expr: 'mover2' '{' mover_properties '}' ;

// The wave module contains parameters for start angle, angular velocity, amplitude, frequency, and phase shift
wave: 'wave' '{' start_angle_expr angle_velocity_expr amplitude_expr frequency_expr phase_shift_expr '}' ;

// The start angle expression defines the initial angle of the wave
start_angle_expr: 'start_angle' ':' value_expr ;

// The angular velocity expression defines the velocity of the wave's angle
angle_velocity_expr: 'angle_velocity' ':' value_expr ;

// The amplitude expression defines the maximum displacement of the wave
amplitude_expr: 'amplitude' ':' value_expr ;

// The frequency expression defines the frequency of the wave
frequency_expr: 'frequency' ':' value_expr ;

// The phase shift expression defines the phase shift of the wave
phase_shift_expr: 'phase_shift' ':' value_expr ;

// The uniform motion module defines a mover and its initial speed
uniform_motion: 'uniform_motion' '{' mover_expr initial_speed_expr '}' ;

// The mover expression defines a basic mover with specific properties
mover_expr: 'mover' '{' mover_basic_properties '}' ;

// The initial speed expression defines the starting speed of the mover
initial_speed_expr: 'initial_speed' ':' value_expr ;

// The accelerated motion module defines a mover, its initial speed, and its initial acceleration
accelerated_motion: 'accelerated_motion' '{' mover_expr initial_speed_expr initial_acceleration_expr '}' ;

// The initial acceleration expression defines the initial acceleration of the mover
initial_acceleration_expr: 'initial_acceleration' ':' value_expr ;

// The circular motion module defines the radius, angular speed, and the ball involved in the motion
circular_motion: 'circular_motion' '{' radius_expr angular_speed_expr ball_expr '}' ;

// The radius expression defines the radius of the circular motion
radius_expr: 'radius' ':' value_expr ;

// The angular speed expression defines the speed of the rotation in the circular motion
angular_speed_expr: 'angular_speed' ':' value_expr ;

// The ball expression defines the ball involved in the circular motion with basic properties
ball_expr: 'ball' '{' mover_basic_properties '}' ;

// The gravity module defines the positions of Earth and the Moon
gravity: 'gravity' '{' earth_expr moon_expr '}' ;

// The Earth expression defines the position of Earth
earth_expr: 'earth' '{' position_expr '}' ;

// The Moon expression defines the position of the Moon
moon_expr: 'moon' '{' position_expr '}' ;

// The spring module defines various properties of the spring, including constant, damping, rest length, floor friction, and the ball
spring: 'spring' '{' spring_constant_expr damping_expr spring_rest_length_expr floor_friction_expr ball_expr spring_expr '}' ;

// The spring constant expression defines the spring's stiffness
spring_constant_expr: 'spring_constant' ':' value_expr ;

// The damping expression defines the damping coefficient for the spring's oscillations
damping_expr: 'damping' ':' value_expr ;

// The spring rest length expression defines the natural length of the spring when no force is applied
spring_rest_length_expr: 'spring_rest_length' ':' value_expr ;

// The floor friction expression defines the friction between the spring and the floor
floor_friction_expr: 'floor_friction' ':' value_expr ;

// The spring anchor point and coil information
spring_expr: 'spring' '{' x_anchor_position_expr y_anchor_position_expr num_coils_expr '}' ;

// The x-anchor position expression defines the x-coordinate of the spring's anchor point
x_anchor_position_expr: 'x_anchor_position' ':' value_expr ;

// The y-anchor position expression defines the y-coordinate of the spring's anchor point
y_anchor_position_expr: 'y_anchor_position' ':' value_expr ;

// The number of coils expression defines the number of coils in the spring
num_coils_expr: 'num_coils' ':' value_expr ;

// The pendulum module defines parameters such as length, ball radius, initial angle, angular velocity, acceleration, and air resistance
pendulum: 'pendulum' '{' length_expr ball_radius_expr initial_angle_expr angular_velocity_expr angular_acceleration_expr air_resistance_expr '}' ;

// The length expression defines the length of the pendulum's arm
length_expr: 'length' ':' value_expr ;

// The ball radius expression defines the radius of the pendulum's ball
ball_radius_expr: 'ball_radius' ':' value_expr ;

// The initial angle expression defines the initial angle of the pendulum
initial_angle_expr: 'initial_angle' ':' value_expr ;

// The angular velocity expression defines the initial angular velocity of the pendulum
angular_velocity_expr: 'angular_velocity' ':' value_expr ;

// The angular acceleration expression defines the acceleration of the pendulum's angular velocity
angular_acceleration_expr: 'angular_acceleration' ':' value_expr ;

// The air resistance expression defines the resistance from air acting on the pendulum
air_resistance_expr: 'air_resistance' ':' value_expr ;

// The rolling uphill module defines parameters for a ball rolling up a hill, including gravitational acceleration, friction, bounciness, angle, and velocity
rolling_uphill: 'rolling_uphill' '{' gravitational_acceleration_expr coefficient_of_friction_expr bounciness_expr angle_expr ball_expr velocity_along_incline_expr '}' ;

// The gravitational acceleration expression defines the strength of gravity acting on the ball
gravitational_acceleration_expr: 'gravitational_acceleration' ':' value_expr ;

// The coefficient of friction expression defines the friction between the ball and the incline
coefficient_of_friction_expr: 'coefficient_of_friction' ':' value_expr ;

// The bounciness expression defines the elasticity of the ball
bounciness_expr: 'bounciness' ':' value_expr ;

// The angle expression defines the angle of the incline
angle_expr: 'angle' ':' value_expr ;

// The velocity along the incline expression defines the ball's speed along the incline
velocity_along_incline_expr: 'velocity_along_incline' ':' value_expr ;

// Basic mover properties, including radius and color
mover_basic_properties: radius_expr color_expr ;

// The mass expression defines the mass of the mover
mass_expr: 'mass' ':' value_expr ;

// The velocity expression defines the velocity in both x and y directions
velocity_expr: 'velocity' '{' x_velocity_expr y_velocity_expr '}' ;

// The x-velocity expression defines the velocity in the x direction
x_velocity_expr: 'x_velocity' ':' value_expr ;

// The y-velocity expression defines the velocity in the y direction
y_velocity_expr: 'y_velocity' ':' value_expr ;

// The position expression defines the position of the mover in both x and y coordinates
position_expr: 'position' '{' x_position_expr y_position_expr '}' ;

// The x-position expression defines the position in the x direction
x_position_expr: 'x_position' ':' value_expr ;

// The y-position expression defines the position in the y direction
y_position_expr: 'y_position' ':' value_expr ;

// The color expression defines the color of the mover in RGB
color_expr: 'color' '{' red_value_expr green_value_expr blue_value_expr '}' ;

// The red value expression defines the amount of red in the color
red_value_expr: 'red_value' ':' value_expr ;

// The green value expression defines the amount of green in the color
green_value_expr: 'green_value' ':' value_expr ;

// The blue value expression defines the amount of blue in the color
blue_value_expr: 'blue_value' ':' value_expr ;

// The value expression can be a simple value, conditional value, or loop value
value_expr: simple_value | conditional_value | loop_value ;

// A simple value can be a number, identifier, or reference
simple_value: NUMBER | IDENTIFIER | reference ;

// A conditional value expression defines a condition with an 'if' statement
conditional_value : 'if' condition 'then' simple_value 'else' simple_value ;

// A loop value expression defines a repetition of a value a specific number of times
loop_value: initial_value 'repeat' INTEGER 'times' '*' multiplier ;

// The initial value for a loop
initial_value: NUMBER ;

// The multiplier in a loop can be a number or simple value
multiplier: NUMBER | simple_value ;

// A condition in a conditional expression compares two simple values
condition: simple_value comparator simple_value ;

// A comparator defines the type of comparison between two values
comparator: '>' | '<' | '==' | '>=' | '<=' | '!=' ;

// A reference refers to an identifier with a sub-identifier (e.g., 'object.property')
reference: IDENTIFIER '.' IDENTIFIER ;

// Token definitions for numbers, integers, floats, and identifiers
NUMBER: INTEGER | FLOAT ;
INTEGER: [0-9]+ ;
FLOAT: [0-9]+ '.' [0-9]+ ;
IDENTIFIER: [a-zA-Z_][a-zA-Z0-9_]* ;

// Inline comments are supported with '//', and these comments are skipped in parsing
COMMENT: '//' ~[\r\n]* -> skip ;

// Whitespace characters are skipped
WS: [ \t\r\n]+ -> skip ;
