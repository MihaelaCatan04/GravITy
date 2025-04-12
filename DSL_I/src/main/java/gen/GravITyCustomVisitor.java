package gen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Această clasă vizitează nodurile din arborele de parsare și extrage datele într-un format simplificat
public class GravITyCustomVisitor extends GravITyBaseVisitor<Object> {

    // O hartă care va stoca întreaga simulare sub formă de chei și valori (ca un obiect JSON)
    private Map<String, Object> simulation = new HashMap<>();

    // Vizităm nodul 'simulation' din gramatică
    @Override
    public Object visitSimulation(GravITyParser.SimulationContext ctx) {
        // Continuăm vizitarea cu corpul simulării
        return visit(ctx.simulation_body());
    }

    // Vizităm nodul 'simulation_body'
    @Override
    public Object visitSimulation_body(GravITyParser.Simulation_bodyContext ctx) {
        // În acest exemplu, presupunem că există un singur modul fizic (ex: collision)
        return visit(ctx.physics_module(0));
    }

    // Vizităm un 'physics_module'
    @Override
    public Object visitPhysics_module(GravITyParser.Physics_moduleContext ctx) {
        // Dacă modulul este de tip collision, vizităm mai departe acel nod
        if (ctx.collision() != null) {
            return visit(ctx.collision());
        }
        // Dacă nu e collision, nu facem nimic (pentru moment)
        return null;
    }

    // Vizităm nodul 'collision'
    @Override
    public Object visitCollision(GravITyParser.CollisionContext ctx) {
        // Creăm un modul de coliziune (folosim o hartă în locul unei clase)
        Map<String, Object> collisionModule = new HashMap<>();

        // Vizităm lista de 'movers' (obiecte în mișcare)
        List<Object> movers = (List<Object>) visit(ctx.movers_list());

        // Adăugăm lista de movers în modulul collision
        collisionModule.put("movers", movers);

        // Salvăm acest modul în simularea principală
        simulation.put("collision", collisionModule);

        return collisionModule;
    }

    // Vizităm lista de 'mover'-i
    @Override
    public Object visitMovers_list(GravITyParser.Movers_listContext ctx) {
        List<Object> movers = new ArrayList<>();

        // Pentru fiecare 'mover' din listă, îl vizităm și îl adăugăm în listă
        for (GravITyParser.MoverContext moverCtx : ctx.mover()) {
            movers.add(visit(moverCtx));
        }

        return movers;
    }

    // Vizităm un singur 'mover'
    @Override
    public Object visitMover(GravITyParser.MoverContext ctx) {
        // Trimitem mai departe la 'mover_properties'
        return visit(ctx.mover_properties());
    }

    // Vizităm proprietățile unui 'mover'
    @Override
    public Object visitMover_properties(GravITyParser.Mover_propertiesContext ctx) {
        Map<String, Object> mover = new HashMap<>();

        // Extragem valoarea pentru rază
        if (ctx.radius_expr() != null) {
            mover.put("radius", ctx.radius_expr().value_expr().getText());
        }

        // Extragem masa
        if (ctx.mass_expr() != null) {
            mover.put("mass", ctx.mass_expr().value_expr().getText());
        }

        // Extragem viteza
        if (ctx.velocity_expr() != null) {
            Map<String, String> velocity = new HashMap<>();
            velocity.put("x", ctx.velocity_expr().x_velocity_expr().value_expr().getText());
            velocity.put("y", ctx.velocity_expr().y_velocity_expr().value_expr().getText());
            mover.put("velocity", velocity);
        }

        // Extragem poziția
        if (ctx.position_expr() != null) {
            Map<String, String> position = new HashMap<>();
            position.put("x", ctx.position_expr().x_position_expr().value_expr().getText());
            position.put("y", ctx.position_expr().y_position_expr().value_expr().getText());
            mover.put("position", position);
        }

        // Extragem culoarea (RGB)
        if (ctx.color_expr() != null) {
            Map<String, String> color = new HashMap<>();
            color.put("r", ctx.color_expr().red_value_expr().value_expr().getText());
            color.put("g", ctx.color_expr().green_value_expr().value_expr().getText());
            color.put("b", ctx.color_expr().blue_value_expr().value_expr().getText());
            mover.put("color", color);
        }

        // Returnăm harta care conține toate informațiile despre acest mover
        return mover;
    }

    // Returnează întreaga structură a simulării după ce s-a vizitat arborele
    public Map<String, Object> getSimulation() {
        return simulation;
    }
}
