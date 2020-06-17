public class NBody
{
    public static double readRadius(String file)
    {
        In in = new In(file);
        in.readInt();
        return in.readDouble();
    }

    public static Planet[] readPlanets(String file)
    {
        In in = new In(file);
        int num = in.readInt(); 
        in.readDouble();
        Planet[] planets = new Planet[num];
        for(int i=0; i<num; i++)
        {
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String img = in.readString();
            Planet planet = new Planet(xxPos, yyPos, xxVel, yyVel, mass, img);
            planets[i] = planet;
        }
        return planets;
    }

    private static void Draw(String file, double radius)
    {
        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        StdDraw.picture(0, 0, file);
        StdDraw.show();
    }

    public static void main(String[] args)
    {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);
        String picture = "images/starfield.jpg";
        Draw(picture, radius);
        for(Planet p: planets)
        {
            p.draw();
        }
        StdDraw.enableDoubleBuffering();
        double cur_t = 0;
        double[] xForces = new double[planets.length];
        double[] yForces = new double[planets.length];
        while(cur_t < T)
        {
            for(int i=0;i<planets.length;i++)
            {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }

            for(int i=0;i<planets.length;i++)
            {
                planets[i].update(dt, xForces[i], yForces[i]);
            }

            for(Planet p: planets)
            {
                p.draw();
            }
            
            StdDraw.show();
            StdDraw.pause(10);
            cur_t += dt;
            int SAMPLING_RATE = 44100;
            double hz = 440.0;
            double duration = 10.0;
            int n = (int) (SAMPLING_RATE * duration);
            double[] a = new double[n+1];
            for (int i = 0; i <= n; i++) {
               a[i] = Math.sin(2 * Math.PI * i * hz / SAMPLING_RATE); 
            }
        }
		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < planets.length; i++) {
    		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
    			planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
		}
    }

}